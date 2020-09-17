<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="500" color="green">
		<h2>파일 업로드 </h2>
		<hr width="500" color="green">
	
		<form action="fileUpload" method="post" enctype="multipart/form-data">
			첨부파일1 : <input type="file" name="file1"> <br/>
			<input type="text" name="book_title" size="50" placeholder="제목" maxlength="50">
			
			<input type="submit" value="전송"/>
		</form>
	</div>
</body>
</html>