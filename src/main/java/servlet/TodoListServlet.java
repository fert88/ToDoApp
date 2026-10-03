package servlet;

import java.io.IOException;
import java.util.List;

import dao.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Todo;
@WebServlet ("/todo/findAll")
public class TodoListServlet extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<Todo> todos=new TodoDAO().findAll();
        request.setAttribute("todos", todos);
        request.getRequestDispatcher("/todo-list.jsp").forward(request, response);
    }    
}