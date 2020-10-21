<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>



<html>

<head>
    <title>Welcome Page</title>

</head>


<body>

   <h1>Выбирите необходимое действие</h1>

       <form action="registrationController" method="post">
           <a href="WEB-INF/jsp/registration.jsp"></a>
           <input type="submit" value="Регистрация" /><br />
       </form>
       <form action="authorizationController" method="post">
           <a href="WEB-INF/jsp/authorization.jsp"></a>
           <input type="submit" value="Вход" /><br />

       </form>

</body>
</html>