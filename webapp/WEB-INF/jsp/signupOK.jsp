<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="model.Account"
%>
<%
Account newAccount = (Account)session.getAttribute("newAccount");
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
<title>ゆるく"つながる" / グリーンフィールド / ユーザー登録が完了しました！</title>
</head>
<body>
<br>
<br>
<br>
<center>
<fieldset style="background:#ddffee; border:4px; border-radius:10px;font-size: 100%; padding: 20px; width:500px; ">
<p><c:out value="${newAccount.getUserId() }" />/<c:out value="${newAccount.getName() }" />さんを登録しました</p>
<a href="index.jsp">トップへ</a>
</fieldset>
</center>
</body>
</html>