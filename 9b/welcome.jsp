<%
    String name = request.getParameter("username");

    session.setMaxInactiveInterval(60);

    if(name != null){
        session.setAttribute("username", name);
    }

    String user = (String) session.getAttribute("username");
%>

<html>
<body>

<%
    if(user != null){
%>
        <h2>Hello <%= user %>!</h2>
        <p>Session will expire in 1 minute.</p>
<%
    } else {
%>
        <h3>Session Expired!</h3>
<%
    }
%>

</body>
</html>
