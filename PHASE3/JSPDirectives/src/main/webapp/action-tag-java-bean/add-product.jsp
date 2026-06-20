<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br>

<jsp:useBean id="product1" class="org.example.Product" scope="page">
</jsp:useBean>
<jsp:setProperty property="*" name="product1" />

<hr>
<p> VERIFICATION OF form data captured
<br> <br> Name  <%=product1.getName() %>
<br> <br> Name  <%=product1.getPrice() %>


