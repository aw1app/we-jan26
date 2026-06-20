<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<!-- JSP declaration tag - used for decl variables and method that can be used anywhere else innthis JSP-->
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

int y1=5;
out.println("<br> y1 = " + y1 + "<br>");
y1++; // this will always be 5+1 for every subseqent user hitting this JSP>
out.println("<br> z1  = " + z1 + "<br>");
z1++; // this will +1  for subseqent user request>
%>

<!-- JSP  expressions are used for printing / displaying stuff on the web page-->
<%= (count++) %> times.

<br> 4  + 5 is : <%= add(4,5) %>.

<%
// TASK: use the add method here:
int result1  = add(14,15);
out.println("<br> 14 + 15 is  " + result1 + "<br>");
%>
</html>