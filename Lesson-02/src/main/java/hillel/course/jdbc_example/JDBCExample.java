package hillel.course.jdbc_example;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaee-20220604-jdbc_example",
                    "postgres", "postgres");
            if (conn != null) {
                System.out.println("Connected to the database!");

                Statement statement = conn.createStatement();

                //create/drop table
                statement.execute(SQL_TABLE_DROP);
                statement.execute(SQL_TABLE_CREATE);

                //insert data to DB
                PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
                PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE);
                PreparedStatement psDelete = conn.prepareStatement(SQL_DELETE);

                psInsert.setString(1, "Zinedine");
                psInsert.setString(2, "Zidane");
                psInsert.setString(3, "Real Madrid");
                psInsert.setString(4, "Midfielder");
                psInsert.setInt(5, 3000);
                psInsert.execute();

                psInsert.setString(1, "Diogo");
                psInsert.setString(2, "Jota");
                psInsert.setString(3, "Liverpool");
                psInsert.setString(4, "Forward");
                psInsert.setInt(5, 2800);
                psInsert.execute();

                //show data from DB
                ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
                System.out.println("There are next footballers in DB:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String team = resultSet.getString("team");
                    String position = resultSet.getString("position");
                    int salary = resultSet.getInt("salary");
                    System.out.printf("id=%d;name=%s,surneme=%s,team=%s,position=%s,salary=%d\n", id, name, surname,
                            team, position, salary);
                }

                //update data for chosen object
                psUpdate.setInt(1, 4000);
                psUpdate.setString(2, "Diogo");
                psUpdate.execute();

                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM FOOTBALLER where name = 'Diogo'");
                while (resultSet1.next()) {
                    int newSalary = resultSet1.getInt("salary");
                    String name = resultSet1.getString("name");
                    String surname = resultSet1.getString("surname");
                    System.out.println("For " + name + " " + surname + " new salary = " + newSalary);
                }

                //delete chosen object from DB
                psDelete.setString(1, "Zinedine");
                psDelete.execute();

                //verify deleted object from DB
                ResultSet resultSet2 = statement.executeQuery(SQL_SELECT_ALL);
                while (resultSet2.next()) {
                    String name = resultSet2.getString("name");
                    if (name.equals("Zinedine")) {
                        throw new SQLDataException("Chosen object was not deleted");
                    } else System.out.println("Footballer Zinedine was deleted from DB");
                }

                conn.close();

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String SQL_TABLE_CREATE = "CREATE TABLE FOOTBALLER"
            + "("
            + " id INT GENERATED ALWAYS AS IDENTITY,"
            + " NAME varchar(100) NOT NULL,"
            + " SURNAME varchar(100) NOT NULL,"
            + " TEAM varchar(100) NOT NULL,"
            + " POSITION varchar(100) NOT NULL,"
            + " SALARY INT"
            + ")";
    private static final String SQL_INSERT = "INSERT INTO FOOTBALLER (NAME, SURNAME, TEAM, POSITION, SALARY) " +
            "VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE FOOTBALLER SET SALARY=? WHERE NAME=?";

    private static final String SQL_DELETE = "DELETE FROM FOOTBALLER WHERE NAME=?";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS FOOTBALLER";

    private static final String SQL_SELECT_ALL = "SELECT * FROM FOOTBALLER";

}
