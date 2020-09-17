<%@page import="_07_board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(int i = 0; i< 8; i++){
			BoardDao.instance.insertDummy();
		}
		response.sendRedirect("01_board_main_test.jsp");
	%>
</body>
</html>