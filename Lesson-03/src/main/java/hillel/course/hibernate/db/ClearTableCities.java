package hillel.course.hibernate.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClearTableCities {
    public static void clearTableInDB() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaee-20220604-hibernate-example",
                    "postgres", "postgres");
            if (conn != null) {
                System.out.println("Connected to the database!");
                Statement statement = conn.createStatement();
                statement.execute(SQL_TABLE_CLEAR);
                conn.close();
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static final String SQL_TABLE_CLEAR = "DELETE From cities";
}
