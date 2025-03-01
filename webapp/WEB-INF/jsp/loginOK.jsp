<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="model.Account"
%>
<%
Account loginAccount = (Account)session.getAttribute("loginAccount");
%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<style>
body {
  background-image: url("green_gradation01.png");
  background-size: cover;
}
</style>
<head>
<meta charset="UTF-8">
<title>ゆるく"つながる" / グリーンフィールド / ログインが成功しました！</title>
</head>
<body>
<br>
<br>
<br>
<center>
<fieldset style="background:#ddffee; border:4px; border-radius:10px;font-size: 100%; padding: 20px; width:500px; ">
<h2>ようこそ<c:out value="${loginAccount.getName() }" />さん</h2>
<a href="Main">ホームへ</a>
</fieldset>
</center>
</body>
</html>