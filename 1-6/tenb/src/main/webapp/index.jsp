<html>
<head>
<script>
function validateForm() {
    let fields = ["roll", "name", "s1", "s2", "s3", "s4", "s5"];

    for (let i = 0; i < fields.length; i++) {
        let val = document.forms["form"][fields[i]].value;
        if (val == "") {
            alert("All fields required!");
            return false;
        }
    }
    return true;
}
</script>
</head>

<body>
<h2>Student Marks</h2>

<form name="form" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="roll"><br><br>
    Name: <input type="text" name="name"><br><br>

    Sub1: <input type="number" name="s1"><br>
    Sub2: <input type="number" name="s2"><br>
    Sub3: <input type="number" name="s3"><br>
    Sub4: <input type="number" name="s4"><br>
    Sub5: <input type="number" name="s5"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>