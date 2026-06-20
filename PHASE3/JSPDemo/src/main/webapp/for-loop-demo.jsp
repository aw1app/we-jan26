<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<br> Displaying numbers 5 to 10 <br>
<%
for (int i=5 ; i<= 10 ; i++ ){
out.println("<br> i="+i );
}
%>

<br> Displaying numbers 5 to 10, another approach <br>
<ul>
<%
for (int i=5 ; i<= 10 ; i++ ){
%>

<li> i= <%=i %> </li>

<% } %>
</ul>

</html>