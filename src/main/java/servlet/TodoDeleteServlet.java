package servlet;

import java.io.IOException;

import dao.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/todo/delete")
public class TodoDeleteServlet extends HttpServlet {
    @Override 
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        TodoDAO dao=new TodoDAO();
        boolean isDeleted=dao.delete(id);
        System.out.println(isDeleted);
        if (isDeleted) {
            response.sendRedirect(request.getContextPath()+"/todo/findAll");
        }

    }
    
}