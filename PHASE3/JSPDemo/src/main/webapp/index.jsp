<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<!-- JSP declaration tag -->
<%! int count = 0 ;%>
<%! int z1 = 10 ;
int z2 = 10 ;
%>

<%!
public int add ( int a, int b){
return a + b;
}
%>


<!-- JSP scriptlets  - use for any kind of java code - especially for logic steps-->
<%
out.println("Welcome to JSPs");
out.println("You have vistied this page " );
%>

<!-- JSP  expressions are used for printing / displaying stuff on the web page-->
<%= (count++) %> times.

<br> 4  + 5 is : <%= add(4,5) %>.

</html>