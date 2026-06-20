<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql"%>

<!DOCTYPE html>

<sql:setDataSource var="estore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/cis_estore" user="root"
	password="rootroot" />

<sql:query dataSource="${estore}" var="resultSet">
SELECT * FROM products
</sql:query>


<br>LIST OF PRODUCTS <br>
<table>
<c:forEach var="row" items="${resultSet.rows}">
		<tr>
			<td>${row.id }
			<td>${row.name }
			<td> ${row.price}
		</tr>
	</c:forEach>
</table>
