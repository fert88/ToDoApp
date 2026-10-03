<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Todo</title>
</head>
<body>

    <h1>New Todo</h1>

    <form action="${pageContext.request.contextPath}/todo/new" method="post">

    <label>Title:</label>
    <input type="text"
           id="title"
           name="title"
           maxlength="25"
           required>

    <br><br>

    <label>Description:</label>
    <textarea id="description"
              name="description"
              maxlength="500"
              required></textarea>

    <br><br>

    <button type="submit">
        Save
    </button>

</form>

</body>
</html>