<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<h1>LOGIN HERE </h1>


<form action="validate-login.jsp"  method="POST">

    Name: <input name="user_id"> <br>
    Price: <input type="password" name="password"> <br><br>

    Name: <input type="submit" value="LOGIN"> <br>

</form>