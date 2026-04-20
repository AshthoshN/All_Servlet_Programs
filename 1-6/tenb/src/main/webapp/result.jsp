<html>
<body>

<h2>Student Result</h2>

Roll No: <%= request.getAttribute("roll") %><br>
Name: <%= request.getAttribute("name") %><br>
Average: <%= request.getAttribute("avg") %><br>
Result: <%= request.getAttribute("result") %><br>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>