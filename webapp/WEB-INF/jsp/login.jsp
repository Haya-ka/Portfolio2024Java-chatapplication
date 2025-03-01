<%@ 
page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
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
<title>ゆるく"つながる" / グリーンフィールド</title>
</head>
<body>
<br>
<br>
<br>
<center>
<fieldset style="background:#ddffee; border:4px; border-radius:10px;font-size: 100%; padding: 20px; width:500px; ">
<h1>グリーンフィールドへようこそ</h1>
<form action="LoginServlet" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<br>
今すぐ始めよう<br>
<fieldset style="background:#336644; border:4px double #ffffff; border-radius:10px;font-size: 100%; padding: 20px; width:200px;">
<a href="SignupServlet" style="color:#ffffff;"><b>ユーザー登録</b></a><br>
</fieldset>
</fieldset>
</center>
</body>
</html>