package _05_bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDAO {
	
	private CartDAO() {}
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() { return instance; }

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB����
	private Connection getConnection() throws Exception {
		String dbURL = "jdbc:mysql://localhost:3306/bookstoredb05?serverTimezone=UTC";
		String dbID = "root";
		String dbPassword = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// id�� �ش��ϴ� ��ٱ��� ���
	public List<CartDTO> getCart(String id){
		
		CartDTO cart = null;
		List<CartDTO> lists = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT * FROM cart WHERE buyer=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			lists = new ArrayList<CartDTO>();
			
			while(rs.next()) {
				cart = new CartDTO();
				
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setBook_id(rs.getInt("book_id"));
				cart.setBook_title(rs.getString("book_title"));
				cart.setBuy_price(rs.getInt("buy_price"));
				cart.setBuy_count(rs.getInt("buy_count"));
				cart.setBook_image(rs.getString("book_image"));
				
				lists.add(cart);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		return lists;
	}
	
	// [��ٱ��Ͽ� ���]�� ������ ����Ǵ� ������
	// cart ���̺��� ���ο� ���ڵ� �߰�
	public void insertCart(CartDTO cart) {
		
		int cart_id = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT MAX(cart_id) FROM cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cart_id = rs.getInt(1);
			}
			
			sql = "INSERT INTO cart (cart_id, book_id, buyer, book_title, buy_price, buy_count, book_image) ";
			sql += "VALUES (?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart_id+1);
            pstmt.setInt(2, cart.getBook_id());
            pstmt.setString(3, cart.getBuyer());
            pstmt.setString(4, cart.getBook_title());
            pstmt.setInt(5, cart.getBuy_price());
            pstmt.setInt(6, cart.getBuy_count());
            pstmt.setString(7, cart.getBook_image());
            
            pstmt.executeUpdate();			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
	}

    //id�� �ش��ϴ� ���ڵ��� ���� ���� �޼ҵ�
    public int getListCount(String id){

        int count = 0;

        try {
            conn = getConnection();
            
            String sql = "SELECT COUNT(*) FROM cart WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
               count= rs.getInt(1);
			}
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
        	if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        	if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        	if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return count;
    }


    // ��ٱ��Ͽ��� ������ ������ ����Ǵ� �޼ҵ�
     public void updateCount(int cart_id, int count) {
         try {
        	 conn = getConnection();
            
        	 String sql = "UPDATE cart SET buy_count=? WHERE cart_id=?";
        	 
             pstmt = conn.prepareStatement(sql);
             pstmt.setInt(1, count);
             pstmt.setInt(2, cart_id);
                        
             pstmt.executeUpdate();
         }catch(Exception e) {
             e.printStackTrace();
         }finally {
        	 if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        	 if(conn != null) {try {conn.close();} catch (SQLException e) {}}
         }
     }
   
     //��ٱ��Ͽ���  cart_id�� ���� ���ڵ带 �����ϴ� �޼ҵ�
     public void deleteList(int cart_id) {
               
         try {
			 conn = getConnection();

			 String sql = "DELETE FROM cart WHERE cart_id=?";
			 
             pstmt = conn.prepareStatement(sql);
             pstmt.setInt(1, cart_id);
             
             pstmt.executeUpdate();
         }catch(Exception e) {
             e.printStackTrace();
         }finally {
        	 if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        	 if(conn != null) {try {conn.close();} catch (SQLException e) {}}
         }
     }
     
     //id�� �ش��ϴ� ��� ���ڵ带 �����ϴ� �޼ҵ�� [��ٱ��� ����] ���߸� Ŭ���� ����ȴ�.
     public void deleteAll(String id) {
         try {
			 conn = getConnection();

			 String sql = "DELETE FROM cart WHERE buyer=?";
			 
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, id);
             
             pstmt.executeUpdate();
         }catch(Exception e) {
             e.printStackTrace();
         }finally {
        	 if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        	 if(conn != null) {try {conn.close();} catch (SQLException e) {}}
         }
     }
	
	
}













