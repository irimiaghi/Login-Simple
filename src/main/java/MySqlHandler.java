import java.sql.*;

public class MySqlHandler {
    private Connection dbConnection;
    public MySqlHandler() throws SQLException {
        dbConnection = DriverManager
                .getConnection(
                        "jdbc:mysql://127.0.0.1:3306/demologin",
                        "root",
                        "admin");
    }
    public boolean addUser(User x) {
        String sqlCmd = "INSERT INTO user(email, username, password)" +
                "VALUES(" + "'" + x.email + "'" + ", " + "'" + x.username + "'" + ", " + "'" + x.password + "'" + ")";
        try {
            Statement statement = dbConnection.createStatement();
            return statement.execute(sqlCmd);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry, please try again!");
            return false;
            //facut ca sa nu iasa din program
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
