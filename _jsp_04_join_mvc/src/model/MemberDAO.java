package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
    // �̱��� ����
    private MemberDAO() {}
    private static MemberDAO instance = new MemberDAO();
    public static MemberDAO getInstance() {
        return instance;
    }
    // MySQL DB ����
    // 1) JDBC
    // 2) Connection Pool(*)
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Connection getConn() throws Exception {
        Context initCtx = new InitialContext();
        
        // lookup �޼��带 ����
        // server.xml ���Ͽ� �����Ͽ� �ڹ�ȯ�� �ڵ带 �˻�
        Context envCtx = (Context)initCtx.lookup("java:comp/env");
        // <Context>�±׾��� <Resource> ȯ�漳����
        // name�� jdbc/pool�� ���� �˻�
        DataSource ds = (DataSource)envCtx.lookup("jdbc/pool");
        conn = ds.getConnection();
        return conn;
    }

    // ���̵� �ߺ�üũ
    public int checkId(String id) {
        // check = 1 (�ߺ�X)
        // check = -1(�ߺ�O)
        int check = 1;
        try {
            // 1.DB ����
            conn = getConn();
            // 2.������ �ۼ�
            String sql = "SELECT * FROM member ";
            sql += "WHERE id=?";
            // 3.���� ��ü ����
            pstmt = conn.prepareStatement(sql);
            // 4.? ����
            pstmt.setString(1, id);
            // 5.���� ����

            // 1) executeUpdate()  : SELECT�� ������ ������
            // 2) executeQuery()   : SELECT
            rs = pstmt.executeQuery();
            // rs.next()�޼����� ���ϰ��� true�̸�
            // ���̵� �ߺ��ȴٴ� �ǹ�
            if(rs.next()) {
                check = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        }
        return check;
    }
    // ȸ������

    public int joinMember(MemberBean bean) {
        int check = 1;
        try {
            //--------------------------------

            // id�ߺ�üũ
            // check = 1(���� ���)
            // check =-1(���� �Ұ�)
            check = checkId(bean.getId());
            //--------------------------------
            // 1.DB����
            conn = getConn();
            if(check == 1) {
                // 2.������ �ۼ�
                String sql = "INSERT INTO member";
                sql += "(id,pw,name,tel,email) ";
                sql += "VALUES(?,?,?,?,?)";
                // 3.������ �����ϱ� ���� ��ü ����
                pstmt = conn.prepareStatement(sql);
                // ? ���� ����
                pstmt.setString(1, bean.getId());
                pstmt.setString(2, bean.getPw());
                pstmt.setString(3, bean.getName());
                pstmt.setString(4, bean.getTel());
                pstmt.setString(5, bean.getEmail());
                // 4.���� ����
                pstmt.executeUpdate();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
        return check;
    }
    // �α���
    public int loginCheck(String id, String pw) {
        int check = -1;
        try {
            // 1.DB ����
            conn = getConn();
            // 2.������ �ۼ�
            String sql = "SELECT pw FROM member ";
            sql += "WHERE id=?";
            // 3.������ ������ ���� ��ü(pstmt) ����
            pstmt = conn.prepareStatement(sql);
            // 4.?�� �� ����
            pstmt.setString(1, id);
            // 5.������ ����
            rs = pstmt.executeQuery();
            if(rs.next()) {
                String dbPw = rs.getString("pw");
                if(dbPw.equals(pw)) {
                    // �α��� ����
                    check = 1;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
        }
        return check;
    }
    // ȸ�� �Ѹ��� ���� ��������
    public MemberBean getOneMember(String id) {
        MemberBean bean = null;
        try {
            // 1.DB����
            conn = getConn();
            // 2.������ �ۼ�
            String sql = "SELECT * FROM member ";
            sql += "WHERE id=?";
            // 3.������ ������ ���� ��ü(pstmt)����
            pstmt = conn.prepareStatement(sql);
            // 4.? ����
            pstmt.setString(1, id);
            // 5.���� ����
            rs = pstmt.executeQuery();
            if(rs.next()) {
                // String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String field = rs.getString("field");
                String skill = rs.getString("skill");
                String major = rs.getString("major");
 
                bean = new MemberBean(id, pw, name, tel, email, field, skill, major);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}            
        }
        return bean;
    }
    // ȸ������ ����
    public void updateMember(String id, MemberBean bean) {
        try {
            // 1.DB����
            conn = getConn();
            // 2.������ �ۼ�
            String sql = "UPDATE member SET ";
            sql += "pw=?, name=?, tel=?, ";
            sql += "email=?, field=?, skill=?, major=? ";
            sql += "WHERE id=?";
            // 3.������ ������ ���� ��ü(pstmt) ����
            pstmt = conn.prepareStatement(sql);
            // 4.?����
            pstmt.setString(1, bean.getPw());
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getTel());
            pstmt.setString(4, bean.getEmail());
            pstmt.setString(5, bean.getField());
            pstmt.setString(6, bean.getSkill());
            pstmt.setString(7, bean.getMajor());
            pstmt.setString(8, id);
            // 5.���� ����
            pstmt.executeUpdate();
            // 6.������� ���� ó��(select�� ����)
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
    }
    // �Ի������ϱ�
    public void apply(String id, String field, String skill, String major) {
        try {
            conn = getConn();
            String sql = "UPDATE member SET field=?, ";
            sql += "skill=?, major=? ";
            sql += "WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, field);
            pstmt.setString(2, skill);
            pstmt.setString(3, major);
            pstmt.setString(4, id);
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
    }
    // Ż���ϱ�
    public void delete(String id) {
        try {
            conn = getConn();
            String sql = "DELETE FROM member WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
        }
    }
}
