<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<%
 String name = request.getParameter("name");
  String ageStr = request.getParameter("age");
  int age  = Integer.parseInt(ageStr);

if(age>18)
    out.println("<h2> "+ name + "<h2>, <h3>  Your vote has been registered. </h3> ");
else
    out.println("<h2> " + name + " with age : "+ age + "<h2>, <h3>  Your vote has NOT been registered. Since you are ineligile </h3> ");
%>

</html>