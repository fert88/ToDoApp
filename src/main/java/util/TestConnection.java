package util;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try(Connection conn=DBConnection.getConnection()) {
            System.out.println("basarili");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("basarisiz");
        }
        
    }
}
