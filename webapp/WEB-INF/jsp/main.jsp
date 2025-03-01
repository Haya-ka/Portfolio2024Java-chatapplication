<%@
page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="model.Account,model.Mutter,java.util.List"
%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
Account loginAccount = (Account)session.getAttribute("loginAccount");
//セッションスコープに保存されたユーザー情報を取得
List<Mutter> mutterList = (List<Mutter>)request.getAttribute("mutterList");
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
<title>ゆるく"つながる" / グリーンフィールド</title>
</head>
<body>
<br>
<fieldset style="background:#ddffee; border:4px; border-radius:10px;font-size: 100%; padding: 20px;">
<h1>グリーンフィールド</h1>
<p>ログイン中：${loginAccount.name }さん　<a href="Main">更新</a></p>
<fieldset style="background:#336644; border:4px double #ffffff; border-radius:10px;font-size: 100%; padding: 20px; width:100px;">
<a href="Logout" style="color:#ffffff;"><center><b>ログアウト</b></center></a>
</fieldset>
<br>
あなたの「今」を伝えよう<br>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${errorMsg != null }">
<p style="color:red;">${errorMsg }</p>
</c:if>
<c:forEach var="mutter" items="${mutterList }" >
<p>
${mutter.userName }：${mutter.text }<span style="color:#999999; font-size: 10px;">　　　投稿時間：${mutter.datetostring }</span>
</p>
</c:forEach>
</fieldset>
</body>
</html>