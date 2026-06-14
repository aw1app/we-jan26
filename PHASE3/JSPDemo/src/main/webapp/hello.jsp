<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%! int count = 0 ;%>

<%
out.println("Welcome to JSPs");
out.println("You have vistied this page " );
%>

<%= (count++) %> times.

</html>