<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<form id="deleteTodoList" method="post" action="${pageContext.request.contextPath}/member/deleteTodoList">
		<input type="hidden" name="todoNo" value="${todoNo}">
		<table class="table table-borderless table-hover">
			<tr class="border-bottom font-weight-bold">
				<td class="text-center"> 삭제를 원하신다면 확인을 위해 아이디를 입력해주세요 : </td>
			</tr>
			<tr class="border-bottom font-weight-bold">
				<td class="text-center"><input type="text" id="memberId" name="memberId"></td>
			</tr>
		</table>
		<div class="text-center"><button id="deleteTodoListbtn" type="button" class=" btn btn-outline-info">삭제</button></div>
	</form>
	<script>
	$('#deleteTodoListbtn').click(function() {
		//버튼을 click했을때
		if($('#memberId').val() == '') { // memberId 공백이면
			alert('memberId를 입력하세요');
			return;
		} else {
			$('#deleteTodoList').submit(); // <button type="button"> -> <button type="submit">
		}
	});
	</script>
	</div>
</body>
</html>