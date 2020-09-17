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
		String pass = request.getParameter("password");
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 데이터 베이스 연결
		
		String password = BoardDao.instance.getPass(num);
		
		// 기존 패스워드 값과 delete form에서 작성한 패스워드 비교
		if(pass.equals(password)){
			// 패스워드가 같으면
			BoardDao.instance.deleteBoard(num);
			
			response.sendRedirect("04_board_lsit.jsp");
		}else{
	%>
		<script type="text/javascript">
			alert("패스워드가 틀립니다.");
			location.href="04_board_list.jsp";
		</script>
	<%				
		}
	%>	
</body>
</html>