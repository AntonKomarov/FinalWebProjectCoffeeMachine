<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>

<html>

<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>

<%--      <fmt:setLocale value="${sessionScope.local}" />--%>
<%--      <fmt:setBundle basename="resources.local" var="loc"/>--%>
<%--      <fmt:message bundle="${loc}" key="local.message" var="message" />--%>
<%--      <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />--%>
<%--      <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />--%>
</head>

<body>

   <h1>Добро пожаловать к нам в гости</h1>
   <h2>Чувствуйте себя как дома и выпейте чашечку горячего, бодрящего напитка</h2>
   <h3>Чтобы сделать заказ выберите необходимое действие</h3>

 <form action="registrationController" method="post">
     <a href="WEB-INF/jsp/registration.jsp"></a>
     <input type="submit" value="Регистрация" /><br />
 </form>

   <form action="authorizationController" method="post">
       <a href="WEB-INF/jsp/authorization.jsp"></a>
       <input type="submit" value="Вход" /><br />

   </form>

<%--          <form action="controller" method="post">--%>
<%--              <input type="hidden" name="local" value="ru"/>--%>
<%--              <input type="submit" value="${ru_button}" /><br />--%>
<%--          </form>--%>

<%--          <form action="controller" method="post">--%>
<%--              <input type="hidden" name="local" value="en">--%>
<%--              <input type="submit" value="${en_button}" /><br />--%>
<%--          </form>--%>

<%--          <c:out value="${message}" />--%>

</body>
</html>