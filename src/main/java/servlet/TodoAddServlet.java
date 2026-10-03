package servlet;

import java.io.IOException;

import dao.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet("/todo/new")
public class TodoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/todo-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title == null || title.isBlank()) {
            response.getWriter().println("Title cannot be empty");
            return;
        }

        if (description == null || description.isBlank()) {
            response.getWriter().println("Description cannot be empty");
            return;
        }
        Todo todo = new Todo(title, description);
        TodoDAO dao = new TodoDAO();
        dao.insert(todo);
        response.sendRedirect(request.getContextPath() + "/todo/findAll");
    }

}
