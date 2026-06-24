<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<sql:setDataSource var="estore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/we_jan_26" user="root"
	password="rootroot" />

<sql:query dataSource="${estore}" var="resultSet">
SELECT * FROM products WHERE id=<%=request.getParameter("id") %>
</sql:query>

<br><br><hr>
<h2>EDIT and SAVE PRODUCT</h2>

<form action="update-product.jsp" method="POST" >
<input type="hidden" name="id" value="${resultSet.rows[0].id}">
Name: <input name="name" value="${resultSet.rows[0].name}"> <br>
Price: <input name="price" value="${resultSet.rows[0].price}"> <br><br>
<input type="submit" value="UPDATE"> <br>
</form>


