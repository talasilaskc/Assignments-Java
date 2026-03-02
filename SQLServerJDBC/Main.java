package SQLServerJDBC;

import java.sql.*;

public class Main {

    static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=InsuranceDB;encrypt=false";
    static final String USER = "TALASILA/DELL";      // or your SQL login
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        try (Connection conn =
                     DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to SQL Server!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Agents");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("AgentID") + " | " +
                                rs.getString("AgentName") + " | " +
                                rs.getDouble("Phone")+" | " +
                                rs.getString("City")+" | " +
                                rs.getString("DevOfId")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

