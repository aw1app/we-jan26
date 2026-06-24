<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<c:set var="x" value="100" />

X IS <c:out value="${x}"/>

<h3>For Loop Example</h3>

<c:forEach var="i" begin="1" end="5">
    Value = <c:out value="${i}" /> <br/>
</c:forEach>


SWITCH demo

<c:set var="marks" value="75" />

<c:choose>

    <c:when test="${marks >= 80}">
        Result: Distinction
    </c:when>

    <c:when test="${marks >= 60}">
        Result: First Class
    </c:when>

    <c:when test="${marks >= 40}">
        Result: Pass
    </c:when>

    <c:otherwise>
        Result: Fail
    </c:otherwise>

</c:choose>