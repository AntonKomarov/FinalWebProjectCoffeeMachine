<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<

<html>
<head>
    <title>Title</title>
</head>

<body>

<h1>Получилось! Выбирай напиток</h1>

<form action="controller" method="post">

    <input type="hidden" name="command" value="add_coffee">
    Введите напиток:<br />
    <input type="text" name="name" value=""><br />
    Введите стоимость:<br />
    <input type="text" name="cost" value=""><br />
    Введите id кофемашины:<br />
    <input type="number" name="coffee_machines_idcoffee_machine" value=""><br />

    <input type="submit" value="Добавить напиток"><br />

</form>


<form action ="controller" method="post">

    <input type = "hidden" name="command" value="add_coffee_machine">
    Введите id пользователя:<br />
    <input type="number" name="idUser" value=""><br />
    Введите модель кофемашины:<br />
    <input type="text" name="model" value=""><br />

    <input type="submit" value="Добавить кофемашину"><br />

</form>

<form action ="controller" method="delete">

    <input type = "hidden" name="command" value="delete_coffee">
    Вид кофе который хотите удалить:<br />
    <input type="text" name="name" value=""><br />

    <input type="submit" value="Удалить"><br />

</form>


</body>
</html>
