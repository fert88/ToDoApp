package dao;
import java.util.List;

import model.Todo;



public class TestDAO {
    public static void main(String[] args) {
        List<Todo> todos=new TodoDAO().findAll();
        for(Todo td:todos){
            System.out.println(td.getTitle());
        }       
    }
}
