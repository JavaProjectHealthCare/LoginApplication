<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <h1 style="color:red;text-align:center">Login Form </h1>
    
    <form:form modelAttribute="loginCmd">
    UserName :: <form:input path="userName"/><br><br>
    Password :: <form:input type="password" path="pwd" /><br><br>
    <input type="submit" value="Login"><br>
    </form:form>
    <br><br>
    
    Result is ::${resultMsg}