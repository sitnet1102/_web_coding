package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/BoardListAction")
public class BoardListAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		

		// ȭ�鿡 ������ �Խñ��� ������ ����
		int pageSize = 10;
		// ���� �������� �ִ� �������� number ���� �о����
		String pageNumber = request.getParameter("pageNum");
		// null ó��
		if(pageNumber == null) {
			pageNumber = "1";
		}
		// ��ü �Խñ��� ����
		int count = 0;
		// JSP������ ������ ������ �ѹ��� ���� ���� �����ϴ� ���� ����
		int number = 0;
		
		// ���� �������� �ִ� ������ ���ڸ� ���ڷ� ����ȯ
		int currentPage = Integer.parseInt(pageNumber);
		// ���� �Խñ��� ������ �����;� �ϱ⿡ �����ͺ��̽� ��ü ����
		BoardDAO bdao = BoardDAO.getInstance();
		count = bdao.getAllCount();
		
		// ���� ������ ������ ���� ��ȣ�� ����
		int startRow = (currentPage - 1) * pageSize;
		
		
		// �ֽű� 10���� �������� �Խñ��� ���� �޾��ִ� �޼��� ȣ��
		Vector<BoardBean> v = bdao.getAllBoard(startRow, pageSize);
		number = count - (currentPage - 1) * pageSize;
		
		// BoardList.jsp������ request��ü�� ��Ƽ� �Ѱ���
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		
		/*System.out.println(number);
		System.out.println(pageSize);
		System.out.println(count);
		System.out.println(currentPage);*/
		
		
		RequestDispatcher dis = request.getRequestDispatcher("02_boardList.jsp");
		dis.forward(request, response);
	}


}

