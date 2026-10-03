package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;
import util.DBConnection;

public class TodoDAO {

    public void insert(Todo todo) {
        final String insertSql = "INSERT INTO todos(title,description,completed) VALUES(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(insertSql)) {
            pStatement.setString(1, todo.getTitle());
            pStatement.setString(2, todo.getDescription());
            pStatement.setBoolean(3, todo.isCompleted());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Todo> findAll() {
        List<Todo> list = new ArrayList<>();
        final String findAll = "SELECT * FROM todos";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(findAll);
                ResultSet result = pStatement.executeQuery();) {

            while (result.next()) {
                Todo todo = new Todo(result.getString(2), result.getString(3), result.getBoolean(4));
                todo.setId(result.getInt(1));
                list.add(todo);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Todo findById(int id) {
        final String findById = "SELECT * FROM todos WHERE id=?";
        Todo res = null;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(findById)) {
            pStatement.setInt(1, id);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                res = new Todo(result.getString("title"), result.getString("description"),
                        result.getBoolean("completed"));
                res.setId(result.getInt("id"));
            } else {
                return res;
            }

        } catch (Exception e) {
            System.out.println("todo bulunamadi exceptionda");
        }

        return res;

    }

    public boolean update(Todo todo) {
        final String updateSql = "UPDATE todos SET title=?, description=?,completed=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(updateSql)) {
            pStatement.setString(1, todo.getTitle());
            pStatement.setString(2, todo.getDescription());
            pStatement.setBoolean(3, todo.isCompleted());
            pStatement.setInt(4, todo.getId());
            int affectedRows = pStatement.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean delete(int id) {
        final String deleteSql = "DELETE FROM todos WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(deleteSql)) {
            pStatement.setInt(1, id);
            return pStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Delete is cancelled");
            return false;
        }
    }

}