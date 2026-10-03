<%@ page import="java.util.List" %>
    <%@ page import="model.Todo" %>

        <!DOCTYPE html>

        <html>

        <head>
            <meta charset="UTF-8">
            <title>Todo Listesi</title>

            <style>
                * {
                    box-sizing: border-box;
                }

                body {
                    margin: 0;
                    font-family: Arial, sans-serif;
                    background: #f4f6f8;
                    color: #333;
                }

                .container {
                    width: 90%;
                    max-width: 1100px;
                    margin: 50px auto;
                }

                .header {
                    display: flex;
                    justify-content: space-between;
                    align-items: center;
                    margin-bottom: 25px;
                }

                .header h1 {
                    margin: 0;
                    font-size: 32px;
                }

                .todo-count {
                    background: #ffffff;
                    padding: 10px 18px;
                    border-radius: 20px;
                    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
                    font-size: 14px;
                }

                .todo-list {
                    display: flex;
                    flex-direction: column;
                    gap: 15px;
                }

                .todo-card {
                    background: white;
                    border-radius: 12px;
                    padding: 20px 25px;
                    box-shadow: 0 3px 12px rgba(0, 0, 0, 0.08);
                    display: grid;
                    grid-template-columns: 60px 1fr 1fr 120px 80px 80px;
                    align-items: center;
                    gap: 20px;
                }

                .todo-id {
                    font-size: 14px;
                    color: #888;
                }

                .todo-title {
                    font-size: 18px;
                    font-weight: bold;
                }

                .todo-description {
                    color: #666;
                    font-size: 14px;
                }

                .status {
                    padding: 7px 12px;
                    border-radius: 20px;
                    font-size: 13px;
                    font-weight: bold;
                    text-align: center;
                }

                .completed {
                    background: #d4edda;
                    color: #155724;
                }

                .not-completed {
                    background: #fff3cd;
                    color: #856404;
                }

                .add-button {
                    margin-left: 10px;
                    padding: 10px 16px;
                    border: none;
                    border-radius: 8px;
                    background: #333;
                    color: white;
                    font-size: 14px;
                    text-decoration: none;
                    cursor: pointer;
                    display: inline-block;
                }

                .add-button:hover {
                    opacity: 0.8;
                }

                .edit-button {
                    padding: 8px 14px;
                    border-radius: 8px;
                    background: #eee;
                    color: #333;
                    text-decoration: none;
                    font-size: 14px;
                }

                .edit-button:hover {
                    background: #ddd;
                }

                .delete-button {
                    padding: 8px 14px;
                    border-radius: 8px;
                    background: #dc3545;
                    color: white;
                    text-decoration: none;
                    font-size: 14px;
                }

                .delete-button:hover {
                    background: #b02a37;
                }

                @media (max-width: 800px) {

                    .todo-card {
                        grid-template-columns: 1fr;
                        gap: 10px;
                    }

                    .header {
                        flex-direction: column;
                        align-items: flex-start;
                        gap: 15px;
                    }
                }
            </style>

        </head>

        <body>

            <div class="container">

                <div class="header">
                    <h1>Todo List</h1>

                    <div class="todo-count">
                        Total Todo: ${todos.size()}
                    </div>
                    <a href="${pageContext.request.contextPath}/todo/new" class="add-button">
                        + New Todo
                    </a>
                </div>

                <div class="todo-list">

                    <% List<Todo> todos = (List<Todo>) request.getAttribute("todos");

                            for (Todo todo : todos) {
                            %>

                            <div class="todo-card">

                                <div class="todo-id">
                                    #<%= todo.getId() %>
                                </div>

                                <div class="todo-title">
                                    <%= todo.getTitle() %>
                                </div>

                                <div class="todo-description">
                                    <%= todo.getDescription() %>
                                </div>

                                <% if (todo.isCompleted()) { %>
                                    <div class="status completed">
                                        Completed
                                    </div>
                                    <% } else { %>
                                        <div class="status not-completed">
                                             Waiting
                                        </div>
                                        <% } %>
                                            <a href="${pageContext.request.contextPath}/todo/edit?id=<%= todo.getId() %>"
                                                class="edit-button">
                                                Edit
                                            </a>
                                            <a href="${pageContext.request.contextPath}/todo/delete?id=<%= todo.getId() %>"
                                                class="delete-button">
                                                Delete
                                            </a>

                            </div>

                            <% } %>

                </div>

            </div>

        </body>

        </html>