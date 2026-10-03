<%@ page import="model.Todo" %>

<%
Todo todo = (Todo) request.getAttribute("todo");
%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Todo</title>
</head>

<body>

<h1>Edit Todo</h1>

<form action="${pageContext.request.contextPath}/todo/edit" method="post">

    <input type="hidden" name="id" value="<%= todo.getId() %>">

    <div>
        <label for="title">Title:</label>
        <input
            type="text"
            id="title"
            name="title"
            maxlength="25"
            required
            value="<%= todo.getTitle() %>"
        >
    </div>

    <br>

    <div>
        <label for="description">Description:</label>
        <textarea
            id="description"
            name="description"
            rows="5"
            cols="40"
            maxlength="500"
            required
        ><%= todo.getDescription() %></textarea>
    </div>

    <br>

    <div>
        <label>
            <input
                type="checkbox"
                name="completed"
                value="true"
                <%= todo.isCompleted() ? "checked" : "" %>
            >
            Completed
        </label>
    </div>

    <br>

    <button type="submit">
        Update
    </button>

</form>

</body>
</html>
