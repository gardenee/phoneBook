<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록폼</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>등록폼</h2>
	<p>
		전화번호를 등록하려면<br>
		아래 항목을 기입하고 "등록" 버튼을 클릭하세요
	</p>
	<form action="./pbc" method="post">
	<input type="hidden" name="action" value="write">
	이름 <input type="text" name="name" value=""><br>
	핸드폰 <input type="text" name="hp" value=""><br>
	회사 <input type="text" name="company" value=""><br>
	
	<button type="submit">등록</button>
	</form>
</body>
</html>