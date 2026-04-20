<%@ page language="java" %>
<html>
<body>

<%
    String name = (String) session.getAttribute("user");

    if (name != null) {
%>
        <h2>Welcome back <%= name %>!</h2>
        <p>Session is still active.</p>
<%
    } else {
%>
        <h2>Session Expired!</h2>
<%
    }
%>

</body>
</html>