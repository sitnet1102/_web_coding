<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="_07_board.BoardDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
		<jsp:useBean id="board" class="_07_board.Board">		
			<jsp:setProperty name="board" property="*"/>
		</jsp:useBean>
	<% 	
		BoardDao.instance.insertBoard(board);
		response.sendRedirect("04_board_list_test.jsp");
	%>
</body>
</html>