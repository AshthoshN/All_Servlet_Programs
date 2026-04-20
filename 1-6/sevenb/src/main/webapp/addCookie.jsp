<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Add Cookie</title>
</head>
<body>

<h2>Cookie Management</h2>

<form method="post">
    Name: <input type="text" name="name" required><br><br>
    Domain: <input type="text" name="domain"><br><br>
    Max Age (seconds): <input type="number" name="maxAge" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

<hr>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String maxAgeStr = request.getParameter("maxAge");

    if(name != null && maxAgeStr != null) {
        int maxAge = Integer.parseInt(maxAgeStr);

        Cookie cookie = new Cookie(name, "SampleValue");

        if(domain != null && !domain.equals("")) {
            cookie.setDomain(domain);
        }

        cookie.setMaxAge(maxAge);

        response.addCookie(cookie);

        out.println("<h3>Cookie Added Successfully!</h3>");
        out.println("Name: " + name + "<br>");
        out.println("Domain: " + domain + "<br>");
        out.println("Max Age: " + maxAge + " seconds<br>");
    }
%>

<br>
<a href="viewCookies.jsp">Go to Active Cookie List</a>

</body>
</html>