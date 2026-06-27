<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<jsp:include page="header.jsp" />
<h1>ADD NEW PRODUCT</h1>


<form action="add-product.jsp"  method="POST">

    Name: <input name="name"> <br>
    Price: <input name="price"> <br><br>

    Name: <input type="submit" value="ADD"> <br>

</form>

</body>
</html>