<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>

<h1>Заполните пустые поля</h1>
<form action="controller" method="post">
    <input type ="hidden" name = "command" value="registration"/>
    Логин:<br />
    <input type ="text" name="login" value =""/><br />
    Пароль:<br />
    <input type ="password" name ="password" value=""/><br />
    Почта:<br />
    <input type ="email" name ="email" value="" /><br />
    Номер телефона:<br />
    <input type ="number" name="phone" value="" /><br />
    Имя:<br />
    <input type ="text" name="name" value="" /><br />
    Фамилия:<br />
    <input type="text" name="surname" value="" /><br />


    <input type="submit" value="Применить" /><br />
</form>


</body>
</html>
