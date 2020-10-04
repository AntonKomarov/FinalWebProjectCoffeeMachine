<%--
  Created by IntelliJ IDEA.
  User: CApp
  Date: 23.09.2020
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Ты что, не помнишь как заходить? Попробуй ещё раз...</h1>
<%--Написать ещё раз--%>
<form action="controller" method="post">
    <input type ="hidden" name = "command" value="authorization"/>
    Логин:<br />
    <input type ="text" name="login" value =""/><br />
    Пароль:<br />
    <input type ="password" name ="password" value=""/><br />
    <input type="submit" value="Применить" /><br />
</form>


</body>
</html>
