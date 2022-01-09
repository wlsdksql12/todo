<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid p-5">
	<div class="container-fluid p-1 my-3 border">
	<div class="jumbotron">
		<h1>${todoDate} todo list</h1>
	</div>
	<table class="table table-borderless table-hover">
		<tr class="border-bottom font-weight-bold">
			<td class="text-center">todoDate</td>
			<td class="text-center">todoContent</td>
			<td class="text-center">createDate</td>
			<td class="text-center">updateDate</td>
			<td class="text-center">수정</td>
			<td class="text-center">삭제</td>
		</tr>
		<c:forEach var="t" items="${todoList}">
			<tr class="border-bottom font-weight-bold">
				<td class="text-center">${todoDate}</td>
				<td class="text-center">${t.todoContent}</td>
				<td class="text-center">${t.createDate}</td>
				<td class="text-center">${t.updateDate}</td>
				<td class="text-center"><a href="${pageContext.request.contextPath}/member/contentUpdate?todoNo=${t.todoNo}&todoDate=${todoDate}">[수정]</a></td>
				<td class="text-center"><a href="${pageContext.request.contextPath}/member/deleteTodoList?todoNo=${t.todoNo}&todoDate=${todoDate}">[삭제]</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="jumbotron">
		<h1>add todo</h1>
	</div>
	<form id="todoList" method="post" action="${pageContext.request.contextPath}/member/addTodo">
		<table>
			<tr>
				<td>todoDate <input type="text" id="todoDate" name="todoDate" value="${todoDate}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>todoContent : <textarea rows="3" cols="50" id="todoContent" name="todoContent"></textarea></td>
			</tr>
			<tr>
				<td>fontColor : <input type="color" name="fontColor"></td>
			</tr>
		</table>
		<button id="todoListbtn" type="button" class=" btn btn-outline-info">add todo</button>
	</form>
	<div style="text-align: right"><a href="${pageContext.request.contextPath}/member/Calender">메인으로</a></div>
	<script>
	$('#todoListbtn').click(function() {
		//버튼을 click했을때
		if($('#todoContent').val() == '') { // todoContent 공백이면
			alert('todoContent를 입력하세요');
			return;
		} else {
			$('#todoList').submit(); // <button type="button"> -> <button type="submit">
		}
	});
	</script>
	</div>
</div>
</body>
</html>