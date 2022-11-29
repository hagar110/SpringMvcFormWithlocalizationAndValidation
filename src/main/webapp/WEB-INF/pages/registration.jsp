<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%    request.setCharacterEncoding("UTF8");   %>
<html xmlns:spring="http://www.springframework.org/tags" xmlns:form="http://www.springframework.org/tags/form">
<head>

    <title>Registration Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        span.error {
            color: red;
            display: inline-block;
        }
    </style>
    <script>
        function redirect() {
            var value = document.getElementById("language").value;
            window.location.href = value;
            return ;
    }
    </script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"  pageEncoding="UTF-8" />
</head>
<body>

<div class="container">
    <form:form modelAttribute="user" method="post" action="/Demo2-1.0-SNAPSHOT/users/registration" >
        <div class="from-row md-4">
            <label for="firstName"><spring:message code="user.firstName"/></label>
            <form:input path="firstName" cssClass="form-control" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="from-row">
            <label for="lastName"><spring:message code="user.lastName"/> </label>
            <form:input path="lastName" cssClass="form-control" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>

        <div>
            <label for="salary"><spring:message code="user.salary"/> </label>
            <form:input path="salary" cssClass="form-control" id="salary" type="number" min="0" step="1"/>
            <form:errors path="salary" cssClass="error"/>
        </div>
        <br>

        <input type="submit" value= <spring:message code="user.add"/> >
    </form:form>
    <form id="languageForm" >
        <select name="language" id ="language">
            <option value="/Demo2-1.0-SNAPSHOT/users/registration?lang=en_US"><spring:message code="lang.en"/> </option>
            <option value="/Demo2-1.0-SNAPSHOT/users/registration?lang=ar_EG"><spring:message code="lang.ar"/> </option>
        </select>
        <button class="btn" type="button" onclick="redirect()"><spring:message code="lang.change"/></button>
    </form>
</div>
</body>
</html>
