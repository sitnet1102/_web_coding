<%@page import="_07_board.BoardDao"%>
<%@page import="_07_board.Board"%>
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
	// 공백 제거 후, 정수형으로 바꿈
	int num = Integer.parseInt(request.getParameter("num"));

	
	
	// BoardBean 타입으로하나의 게시글을 리턴
	Board bean = BoardDao.instance.getOneBoard(num);
	
%>

<div align="center">
	<h2> 게시글 보기 </h2>
	<table border="1">
		<tr height="40">
			<td align="center" width="120"> 글번호 </td>
			<td align="center" width="180"> <%= bean.getNum() %></td>
			<td align="center" width="120"> 조회수 </td>
			<td align="center" width="180"> <%= bean.getReadcount() %></td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 작성자 </td>
			<td align="center" width="180"> <%= bean.getWriter() %></td>
			<td align="center" width="120"> 작성일 </td>
			<td align="center" width="180"> <%= bean.getReg_date() %></td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 이메일 </td>
			<td align="center" colspan="3"> <%= bean.getEmail() %></td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 제목 </td>
			<td align="center" colspan="3"> <%= bean.getSubject() %></td>
		</tr>
		<tr height="80">
			<td align="center" width="120"> 글 내용 </td>
			<td align="center" colspan="3"> <%= bean.getContent() %></td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
				
				<input type="button" value="답글쓰기" onclick="location.href='10_board_reWrite_test.jsp?num=<%= bean.getNum() %>'">
				<input type="button" value="수정하기" onclick="location.href='06_board_update_test.jsp?num=<%= bean.getNum() %>'" >
				<input type="button" value="삭제하기" onclick="location.href='08_board_delete_test.jsp?num=<%= bean.getNum() %>'" >
				<input type="button" value="목록보기" onclick="location.href='04_board_list_test.jsp'" >
			</td>
		</tr>
	</table>
</div>


</body>
</html>