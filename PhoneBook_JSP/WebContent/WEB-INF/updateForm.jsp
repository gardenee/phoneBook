<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.PersonVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>수정폼</h2>
	<p>
		수정 화면입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요
	</p>
	<form action="./pbc" method="post">
	<input type="hidden" name="action" value="update">
	이름 <input type="text" name="name" value="${p.name}"><br>
	핸드폰 <input type="text" name="hp" value="${p.hp}"><br>
	회사 <input type="text" name="company" value="${p.company}"><br>
	ID <input  type="text" name="id" value="${p.personId}" readonly><br> 
	
	<button type="submit">수정</button>
	</form>
</body>
</html>