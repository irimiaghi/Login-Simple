import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try {
            Login app = new Login();
            app.start();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Startup failed");
        }
    }
}