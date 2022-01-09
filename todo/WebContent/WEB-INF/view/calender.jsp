<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="jumbotron">
		<h1>${loginMember.memberId}님 반갑습니다.</h1>
	</div>
	<ul class="nav">
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/Logout">로그아웃</a>
		</li>
		<li class="nav-item">
			<c:if test="${loginMember.memberId != 'admin'}">
				<a class="nav-link" href="${pageContext.request.contextPath}/member/Remove">회원탈퇴</a>
			</c:if>
		</li>
	</ul>
	
	<!-- 달력 + todo -->
	<h1>
		<ul class="pagination">
			<span><li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/member/Calender?currentYear=${targetYear}&currentMonth=${targetMonth}&option=pre">이전</a></li></span>
			<h1>${targetYear}년 ${targetMonth}월</h1>
			<span><li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/member/Calender?currentYear=${targetYear}&currentMonth=${targetMonth}&option=next">다음</a></li></span>
		</ul>
	</h1>
	
	<div class="text-primary">
		이달의 total todo : ${todoList.size()}
	</div>
	<table class="table table-hover" border="1" width="100%">
		<tr>
			<td class="text-dark">일</td>
			<td class="text-dark">월</td>
			<td class="text-dark">화</td>
			<td class="text-dark">수</td>
			<td class="text-dark">목</td>
			<td class="text-dark">금</td>
			<td class="text-dark">토</td>
		</tr>
		<tr>
			<!-- JSTL for문 -->
			<c:forEach var="i" begin="1" end="${startBlank+endDay+endBlank}" step="1">
				<c:if test="${i-startBlank >= 1 && i-startBlank<=endDay}">
					<td>
						<a href="${pageContext.request.contextPath}/member/TodoList?y=${targetYear}&m=${targetMonth}&d=${i-startBlank}">${i-startBlank}</a>
						<div>
							<!-- 날짜별 일정 -->
							<c:forEach var="todo" items="${todoList}">
								<c:if test="${(i-startBlank) == todo.todoDate.substring(8)}">
									<div style="color:${todo.fontColor};">${todo.todoContent}</div>
								</c:if>
							</c:forEach>
						</div>
					</td>
				</c:if>
				<c:if test="${i-startBlank < 1 || i-startBlank>endDay}">
					<td>&nbsp;</td>
				</c:if>
				
				<c:if test="${i%7 == 0}">
					<tr></tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
	</div>
</div>	
</body>
</html>