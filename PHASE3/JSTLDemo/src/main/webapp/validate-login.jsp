<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />

<sql:setDataSource var="estore" driver="com.mysql.cj.jdbc.Driver"	url="jdbc:mysql://localhost:3306/we_jan_26" user="root"	password="rootroot" />

<sql:query dataSource="${estore}" var="resultSet">
SELECT * FROM USERS WHERE user_id=<%=request.getParameter("user_id") %> and password='<%=request.getParameter("password")%>'
</sql:query>

<c:choose>
    <c:when test="${resultSet.rowCount > 0}">
        <!-- Save values in Session -->
        <c:set var="name" value="${resultSet.rows[0].name}" scope="session"/>
        <jsp:forward page="products.jsp" />
    </c:when>

    <c:otherwise>
          Invalid Username or Password
            <a href="login.jsp"> Try Again  </a>
    </c:otherwise>

</c:choose>