<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Введите данные</h1>

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
