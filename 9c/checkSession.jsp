<%
    String user = (String) session.getAttribute("username");
%>

<html>
<body>

<%
    if(user != null){
%>
        <h2>Hello <%= user %>! Session Active</h2>
<%
    } else {
%>
        <h3>Session Expired!</h3>
<%
    }
%>

</body>
</html>