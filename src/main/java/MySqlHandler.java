import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlHandler {
    private Connection dbConnection;

    public MySqlHandler() throws SQLException {
        dbConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demologin", "root", "admin");
    }

    public boolean addUser(User x) {
        String sqlCmd = "INSERT INTO user(username, password, email)" +
                "VALUES (\'" + x.username + "\', \'" + x.password + "\', \'" + x.email+ "\')";
        try {
            Statement statement = dbConnection.createStatement();
            return statement.execute(sqlCmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loginUser(String nume, String parola){
        String sqlCmd = "SELECT * FROM demologin.user where username=\'"+nume+"\' and password = \'"+parola+"\';";
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCmd);
            if (resultSet.next()){
                System.out.println("Login successful!");
                return true;
            }
            else{
                System.out.println("Wrong username/password");
            }
//            List usernames = new ArrayList<String>();
//            while(resultSet.next()) {
//                System.out.println("Te-ai logat!");
//                usernames.add(resultSet.getString(1));
//            }
//            if(usernames.isEmpty()) {
//                System.out.println("nope");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String username, String password) {
        String sqlCmd = "update user set password=\""+password+"\" where username=\""+ username+"\"";
        System.out.println(sqlCmd);
        try {
            Statement statement = dbConnection.createStatement();
            return statement.execute(sqlCmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmail(String username, String email) {
        String sqlCmd = "update user set email=\""+email+"\" where username=\""+ username+"\"";
        try {
            Statement statement = dbConnection.createStatement();
            return statement.execute(sqlCmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}