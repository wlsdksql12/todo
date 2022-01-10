<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<div class="container p-3 my-3 border">

	<table class="table table-borderless table-hover">
		<tr class="border-bottom font-weight-bold">
			<td class="text-center">공지사항 넘버</td>
			<td class="text-center">제목</td>
			<td class="text-center">공지사항 내용</td>
			<td class="text-center">생성 날짜</td>
			<td class="text-center">수정 날짜</td>
		</tr>
		<tr class="table table-borderless table-hover">
			<td class="text-center">${notice.noticeNo}</td>
			<td class="text-center">${notice.noticeTitle}</td>
			<td class="text-center">${notice.noticeContent}</td>
			<td class="text-center">${notice.createDate}</td>
			<td class="text-center">${notice.updateDate}</td>
		</tr>
	</table>

	</div>
</div>
</body>
</html>