<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<br> Vote eligibility test <br>
<%! int age = 24 ; %>

<%
if (age > 18 ) {
out.println(" You are eligibile to vote" );
}else{
out.println(" You are NOT eligibile to vote" );
}
%>

<br><br> Vote eligibility test , another approach
<ul>
<% if (age > 18 ) { %>
<br> You are eligibile to vote
<% } else { %>
<br> You are NOT eligibile to vote
<% } %>
</ul>

</html>