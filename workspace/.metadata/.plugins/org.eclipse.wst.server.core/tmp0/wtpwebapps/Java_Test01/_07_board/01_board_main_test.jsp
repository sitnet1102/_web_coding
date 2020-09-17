<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="_07_board.BoardDao" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardDao.instance.realpath = application.getRealPath("");
		System.out.println(application.getRealPath(""));
		BoardDao.instance.loadData();
	%>
	<h2>메인페이지	</h2>
	<p><a href="02_board_write_test.jsp">게시판 글쓰기</a>
	<p><a href="04_board_list_test.jsp">전체 게시판 보기</a>
	<br><br>
	<p><a href="12_board_dummyPro_test.jsp">더미 추가</a>
</body>
</html>