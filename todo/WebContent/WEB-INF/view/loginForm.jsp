<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="container p-3 my-3 border">
	<form id="loginForm" method="post" action="${pageContext.request.contextPath}/Login">
		<table class="table table-borderless table-hover">
			<tr class="border-bottom font-weight-bold">
				<td class="text-right"> 아이디 : </td>
				<td class="text-center"><input id="memberId" type="text" name="memberId"></td>
			</tr>
			<tr class="border-bottom font-weight-bold">
				<td class="text-right"> 비번 : </td>
				<td class="text-center"><input id="memberPw" type="password" name="memberPw"></td>
			</tr>
		</table>
		<div class="text-center"><button id="loginbtn" type="button" class=" btn btn-outline-info">로그인</button></div>
	</form>

	</table>
	<a href="${pageContext.request.contextPath}/adminlogin">관리자 로그인</a>
	<!-- 1) /adminLogin, adminLoginController.doGet(), admin.jsp -->
	<!-- 2) /adminLogin, adminLoginController.dopost(), /admin/adminIndex, adminIndexContoller.doGet(), adminIndex.jsp -->
	<script>
	$('#loginbtn').click(function() {
		//버튼을 click했을때
		if($('#memberId').val() == '') { // memberId 공백이면
			alert('memberId를 입력하세요');
			return;
		} else if($('#memberPw').val() == '') { // memberPw 공백이면
			alert('memberPw를 입력하세요');
			return;
		} else {
			$('#loginForm').submit(); // <button type="button"> -> <button type="submit">
		}
	});
	</script>
	
	</div>
</div>
</body>
</html>