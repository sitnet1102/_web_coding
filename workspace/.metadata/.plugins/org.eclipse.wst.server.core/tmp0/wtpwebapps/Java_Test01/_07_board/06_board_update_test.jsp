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
	<div align="center">
		<h2> 게시글 수정 </h2>
		<%
			// 해당 게시글 번호를 통하여 게시글을 수정
			int num = Integer.parseInt(request.getParameter("num"));
		
			// 하나의 게시글에 대한 정보를 리턴
			Board bean = BoardDao.instance.getOneUpdateBoard(num);
		%>
		
		<form action="07_board_updatePro_test.jsp" method="post">
			<table border="1">
				<tr height="40">
					<td width="120" align="center"> 작성자 </td>
					<td width="180" align="center"> <%= bean.getWriter() %></td>
					<td width="120" align="center"> 작성일 </td>
					<td width="180" align="center"> <%= bean.getReg_date() %></td>
				</tr>
				<tr height="40">
					<td width="120" align="center"> 제목 </td>
					<td width="480" colspan="3"> &nbsp; 
						<input type="text" name="subject" value="<%= bean.getSubject() %>" size="60" />
					</td>				
				</tr>
				<tr height="40">
					<td width="120" align="center"> 패스워드 </td>
					<td width="480" colspan="3"> &nbsp;
						<input type="password" name="password" size="60" />
					</td>
				</tr>
				<tr height="40">
					<td width="120" align="center"> 글내용 </td>
					<td width="480">
						<textarea rows="10" cols="60" name="content">
							<%= bean.getContent() %>
						</textarea>
					</td>
				</tr>
				<tr height="40">
					<td colspan="4" align="center">
						<input type="hidden" name="num" value="<%= bean.getNum() %>" />
						<input type="hidden" name="writer" value="<%= bean.getWriter() %>" />
						<input type="hidden" name="reg_date" value="<%= bean.getReg_date() %>" />						
						<input type="submit" value="글수정" /> &nbsp;&nbsp;
						<input type="button" onclick="location.href='04_board_list_test.jsp'" value="전체글보기" />
					</td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>