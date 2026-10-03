package servlet;
import java.io.IOException;

import dao.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Todo;

@WebServlet ("/todo/edit")
public class TodoEditServlet extends HttpServlet {
    @Override 
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        Todo todo=new TodoDAO().findById(id);
        request.setAttribute("todo", todo);
        request.getRequestDispatcher("/todo-edit.jsp").forward(request, response);
    }
    @Override 
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        TodoDAO dao=new TodoDAO();
        Todo todo=dao.findById(Integer.parseInt(request.getParameter("id")));
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
        todo.setTitle(request.getParameter("title"));
        todo.setDescription(request.getParameter("description"));
        todo.setCompleted(request.getParameter("completed")!=null);
        dao.update(todo);
        response.sendRedirect(request.getContextPath() + "/todo/findAll");

    }

    
}