<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="_07_board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="_07_board.BoardDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전체 게시글 보기</h2>

	<%
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		if(pageNum ==null){
			pageNum = "1";
		}
		int count = 0;
		int number = 0;
		int curPage = Integer.parseInt(pageNum); 
		count = BoardDao.instance.getAllCount();
		
		int startRow = (curPage - 1) * pageSize;
		int endRow = curPage * pageSize;
		ArrayList<Board> list = BoardDao.instance.getAllBoard(startRow, endRow);
		number = count - (curPage - 1) * pageSize;		
	%>
	<div align="center">
	<table border="1" >
		<tr height="40">
			<td align="right" colspan="5"><input type="button" value="글쓰기"
				onclick="location.href='02_board_write_test.jsp'"></td>
		</tr>

		<tr height="40">
			<td width="50" align="center">번호</td>
			<td width="320" align="center">제목</td>
			<td width="100" align="center">작성자</td>
			<td width="150" align="center">작성일</td>
			<td width="50" align="center">조회수</td>
		</tr>
		<%
		for(int i=0; i<list.size(); i++){	
			// 리스트 에 저장되어 있는 빈 클래스를 하나씩 추출
			Board bean = list.get(i); %>
		<tr height="40">
			<%-- 답변형 게시판으로 정렬을 했기 때문에, getNum()으로 번호를 추출하면,
				번호가 뒤죽박죽 마구 섞이게 된다. --%>
			<td width="50" align="center"><%= number-- %></td>
			<%-- 글 제목은 들여쓰기 때문에 왼쪽정렬할 필요가 있다. --%>
			<td width="100" align="left">
				<%
					if(bean.getRe_step() > 1){
							
							for(int j=0; j<(bean.getRe_step()-1)*5; j++){
					%> &nbsp; <%			
							}
						}
					%> <a href="05_board_info_test.jsp?num=<%= bean.getNum() %>"
				style="text-decoration: none"> <%= bean.getSubject() %></a>
			</td>
			<td width="320" align="center"><%= bean.getWriter() %></td>
			<td width="150" align="center"><%= bean.getReg_date() %></td>
			<td width="50" align="center"><%= bean.getReadcount() %></td>
		</tr>
		<%
		}
	%>
	</table>
	
	<%-- 페이지 카운터링 소스를 작성   --%>
	<p></p>
			 	<%
			if(count > 0){
				int pageCount = count / pageSize + (count %
						pageSize == 0 ? 0 : 1);	// 카운터링 숫자를 얼마까지 보여줄건지 결정
				
				
				int startPage = 1;
				
				if(curPage % pageSize != 0){
					startPage = (int)(curPage / pageSize) * pageSize + 1;
				}else{
					startPage = ((int)(curPage / pageSize )- 1) * pageSize + 1;
				}
		
				
				int endPage = startPage + pageSize - 1;	// 화면에 보여질 페이지의 마지막 숫자
				
				if(endPage > pageCount) endPage = pageCount;
					
				// 이전이라는 링크를 만들건지 파악
				if(startPage > 10){
		%>
			<a href="04_board_list_test.jsp?pageNum=<%= startPage - 10 %>"> [이전] </a>
		<%
				}
				// 페이징 처리
				for(int i=startPage; i<=endPage; i++){
		%>
			<a href="04_board_list_test.jsp?pageNum=<%= i %>"> [<%= i %>] </a>
		<%
					
				}
				// 다음이라는 링크를 만들건지 파악
				if(endPage < pageCount){
		%>
			<a href="04_board_list_test.jsp?pageNum=<%= startPage + 10 %>"> [다음] </a>
		<%
				}
			}
		 %>
	
	</div>
</body>
</html>