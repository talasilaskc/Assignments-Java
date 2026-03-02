package JDBC;

import java.sql.*;

public class Main {

    // DB configuration
    static final String URL =
            "jdbc:mysql://localhost:3306/sample_db";
    static final String USER = "root";
    static final String PASSWORD = "Talasila2005";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to database!");

            insertMovie(conn);
            readMovies(conn);
            updateMovie(conn);
            deleteMovie(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Insert record
    static void insertMovie(Connection conn) throws SQLException {
        String sql = "INSERT INTO movies(title, genre, duration, price) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Batman");
        ps.setString(2, "Action");
        ps.setInt(3, 160);
        ps.setDouble(4, 230);

        ps.executeUpdate();
        System.out.println("Movie inserted.");
    }

    // Read records
    static void readMovies(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

        System.out.println("\nMovies List:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("title") + " | " +
                            rs.getString("genre") + " | " +
                            rs.getInt("duration") + " mins | ₹" +
                            rs.getDouble("price")
            );
        }
    }

    // Update record
    static void updateMovie(Connection conn) throws SQLException {
        String sql = "UPDATE movies SET price=? WHERE title=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, 260);
        ps.setString(2, "Avengers");

        ps.executeUpdate();
        System.out.println("\nMovie updated.");
    }

    // Delete record
    static void deleteMovie(Connection conn) throws SQLException {
        String sql = "DELETE FROM movies WHERE title=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Batman");

        ps.executeUpdate();
        System.out.println("Movie deleted.");
    }
}


