 <%-- 07_bookRegisterForm.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>관리자 책등록</title>
	</head>
	<body>
		<%-- 로그아웃 상태 --%>
		<c:if test="${ empty sessionScope.mngId }">
			<script type="text/javascript">
				location.href='/_jsp_06_bookstore_mvc/mg/main.do';
			</script>
			<%-- 0초만에 해당 페이지로 이동 --%>
			<meta http-equiv="Refresh" content="0;url=/book_jsp2/mg/main.do" >
		</c:if>
		
		<%-- 로그인 상태 --%>
		<button onclick="window.location.href='/_jsp_06_bookstore_mvc/mg/main.do'">
			관리자 메인으로		
		</button>
		<button onclick="window.location.href='/_jsp_06_bookstore_mvc/mg/bookList.do'">
			목록으로
		</button>
		<br><br>
		<form method="post" action="/_jsp_06_bookstore_mvc/mg/bookRegisterPro.do" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th>분류선택</th>
					<td>
						<select name="book_kind">
							<option value="100">문학</option>
							<option value="200">외국어</option>
							<option value="300">컴퓨터</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="book_title" size="50" placeholder="제목" maxlength="50">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<input type="text" name="book_price" size="10" placeholder="가격" maxlength="9">원
					</td>
				</tr>
				<tr>
					<th>수량</th>
					<td>
						<input type="text" name="book_count" size="10" placeholder="수량" maxlength="5">권
					</td>
				</tr>
				<tr>
					<th>저자</th>
					<td>
						<input type="text" name="author" size="20" placeholder="저자" maxlength="30" >
					</td>
				</tr>
				<tr>
					<th>출판사</th>
					<td>
						<input type="text" name="publishing_com" placeholder="출판사" maxlength="30" >
					</td>
				</tr>
				<tr>
					<th>출판일</th>
					<td>
						<jsp:useBean id="nowTime" class="java.util.Date" />
						<fmt:formatDate var="nowTimeStr" pattern="yyyy-MM-dd" value="${ nowTime }" />
						<fmt:parseNumber var="lastYear" type="number" value="${ nowTimeStr.toString().substring(0,4) }" />
						
						<select name="publishing_year">
							<c:forEach var="i" begin="2010" end="${ lastYear }">
								<option value="${ i }">${ i }</option>
							</c:forEach>
						</select>년 
						<select name="publishing_month">
							<c:forEach var="i" begin="1" end="12">
								<option value="${ i }">${ i }</option>
							</c:forEach>
						</select>월 
						<select name="publishing_day">
							<c:forEach var="i" begin="1" end="31">
								<option value="${ i }">${ i }</option>
							</c:forEach>
						</select>일 
					</td>
				</tr>
				<tr>
					<th>책 이미지</th>
					<td>
						<input type="file" name="book_image">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="book_content" rows="13" cols="50"></textarea>
					</td>
				</tr>
				<tr>
					<th>할인율</th>
					<td>
						<input type="text" name="discount_rate" size="5" placeholder="10" maxlength="2">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="책등록">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>










