<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<a href="products.jsp"> LIST PRODUCTS</a>     |
<a href="new-product.jsp"> ADD PRODUCT </a>      |

<c:choose>
    <c:when test="${not empty sessionScope.name}">
       Welcome ${sessionScope.name},   <a href="logout.jsp"> LOGOUT  </a>
    </c:when>

    <c:otherwise>
        <a href="login.jsp"> LOGIN  </a>
    </c:otherwise>
</c:choose>

<br><br>