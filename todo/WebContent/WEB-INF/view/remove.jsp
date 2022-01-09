<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="container p-3 my-3 border">
	<%
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);
	%>
	<form id="remove" method="post" action="${pageContext.request.contextPath}/member/Remove">
		<div><input type="hidden" value=<%=memberId%> name="memberId"></div>
		<table class="table table-borderless table-hover">
			<tr class="border-bottom font-weight-bold">
				<td class="text-right"> 비번 : </td>
				<td class="text-center"><input type="password" id="memberPw" name="memberPw"></td>
			</tr>
		</table>
		<div class="text-center"><button id="removebtn" type="button" class=" btn btn-outline-info">로그인</button></div>
	</form>
	<script>
	$('#removebtn').click(function() {
		//버튼을 click했을때
		if($('#memberPw').val() == '') { // memberPw 공백이면
			alert('memberPw를 입력하세요');
			return;
		} else {
			$('#remove').submit(); // <button type="button"> -> <button type="submit">
		}
	});
	</script>
	</div>
</div>
</body>
</html>