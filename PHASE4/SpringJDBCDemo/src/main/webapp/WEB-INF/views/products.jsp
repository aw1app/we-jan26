<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql"%>
<!DOCTYPE html>

<br>LIST OF PRODUCTS <br>
<table border=1>
	<tr style="background-color:lightgrey">
		<th>ID
		<th>NAME
		<th>PRICE
		<th>DESCRPTION
	</tr>

<c:forEach var="row" items="${products}">
		<tr>
			<td>${row.id }
			<td>${row.name }
			<td> ${row.price}
			<td> ${row.description}
		</tr>
	</c:forEach>
</table>