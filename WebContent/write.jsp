<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>본격! 게시판 - 게시글 글쓰기</title>
</head>
<body>
	<form action="insert.do">
		<label>제목</label>
		<input type="text" name="title"> <br>
		<label>작성자</label>
		<input type="text" name="writer"> <br>
		<label>내용</label>
		<textarea name="content"/></textarea> <br>
		<input type="submit" value="확인">
	</form>
</body>
</html>