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
	<form id="contentUpdate" method="post" action="${pageContext.request.contextPath}/member/contentUpdate">
		<input type="hidden" name="memberId" value="${memberId}">
		<input type="hidden" name="todoDate" value="${todoDate}">
		<input type="hidden" name="todoNo" value="${todoNo}">
		<table class="table table-borderless table-hover">
			<tr class="border-bottom font-weight-bold">
				<td class="text-right"> 변경하고자 하는 content : </td>
				<td class="text-center"><textarea rows="3" cols="50" id="todoContent" name="todoContent"></textarea></td>
			</tr>
		</table>
		<div class="text-center"><button id="contentUpdatebtn" type="button" class=" btn btn-outline-info">수정</button></div>
	</form>
	<script>
	$('#contentUpdatebtn').click(function() {
		//버튼을 click했을때
		if($('#todoContent').val() == '') { // todoContent 공백이면
			alert('todoContent를 입력하세요');
			return;
		} else {
			$('#contentUpdate').submit(); // <button type="button"> -> <button type="submit">
		}
	});
	</script>
	</div>
</div>
</body>
</html>