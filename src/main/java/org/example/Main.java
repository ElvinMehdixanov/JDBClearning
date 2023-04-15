package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/lcwaikiki";
            String username = "postgres";
            String password = "1961";
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
            while (rs.next()){
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int  major_id = rs.getInt("major_id");
                System.out.println("ID: " + id + ", Name: " + name + ", Major ID: " + major_id);
            }

            rs.close();
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
