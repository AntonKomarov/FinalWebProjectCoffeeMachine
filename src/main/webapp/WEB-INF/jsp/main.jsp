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

    <input type = "hidden" name="command" value="delete_coffee">
    Вид кофе который хотите удалить:<br />
    <input type="text" name="name" value=""><br />

    <input type="submit" value="Удалить"><br />

</form>


<form action ="controller" method="post">

    <input type = "hidden" name="command" value="add_coffee_machine">
    Введите id пользователя:<br />
    <input type="number" name="idUser" value=""><br />
    Введите модель кофемашины:<br />
    <input type="text" name="model" value=""><br />

    <input type="submit" value="Добавить кофемашину"><br />

</form>

<form action ="controller" method="post">

    <input type = "hidden" name="command" value="delete_coffee_machine">
    Вид модель кофемашины которую хотите удалить:<br />
    <input type="text" name="model" value=""><br />

    <input type="submit" value="Удалить"><br />

</form>



<form action ="controller" method="post">

    <input type = "hidden" name="command" value="take_order">
    Выберите кофе и введите данные для оплаты:<br />
    <input type="text" name="coffee_name" value=""><br />
    <input type="text" name="coffee_value" value=""><br />
    <input type="text" name="card_number" value=""><br />
    <input type="text" name="ownerName" value=""><br />
    <input type="text" name="endDate" value=""><br />
    <input type="text" name="cvv" value=""><br />

    <input type="submit" value="Оплатить"><br />

</form>



</body>
</html>
