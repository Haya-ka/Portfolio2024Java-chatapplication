<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>
<%
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String)request.getAttribute("errorMsg");
%>
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
<title>ゆるく"つながる" / グリーンフィールド / ユーザー登録</title>
</head>
<body>
<br>
<br>
<br>
<center>
<fieldset style="background:#ddffee; border:4px; border-radius:10px;font-size: 100%; padding: 20px; width:500px; ">
<h1>グリーンフィールド</h1>
- ユーザー登録 -<br><br>
<form action="SignupServlet" method="post">
<table>
<tr><td align="left">ユーザーID：</td><td><input type="text" name="userId" pattern="^[a-zA-Z0-9]+$"></td></tr>
<tr><td align="left">パスワード：</td><td><input type="password" name="pass"></td></tr>
<tr><td align="left">メールアドレス：</td><td><input type="text" name="mail"></td></tr>
<tr><td align="left">姓名：</td><td><input type="text" name="name"></td></tr>
</table>
<input type="submit" value="登録">
</form>
<p style="color:red">${errorMsg }</p>
<a href="index.jsp">トップへ</a>
</fieldset>
</center>
</body>
</html>