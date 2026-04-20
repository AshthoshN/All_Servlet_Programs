<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>View Cookies</title>
</head>
<body>

<h2>Active Cookies</h2>

<%
    Cookie[] cookies = request.getCookies();

    if(cookies != null) {
        for(Cookie c : cookies) {
%>
            Name: <%= c.getName() %> <br>
            Value: <%= c.getValue() %> <br>
            Max Age: <%= c.getMaxAge() %> <br>
            -------------------------<br>
<%
        }
    } else {
        out.println("No cookies found.");
    }
%>

<br>
<a href="addCookie.jsp">Back</a>

</body>
</html>