import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        //  User user = new User ("gigi", "asdf", "gigi@gigi.com");
        // User user2 = new User ("petru", "qwerty", "petrisor@gigi.com");
        try {
            DemoLogin app = new DemoLogin();
            //app.register(user);
            //app.register(user2);
            app.start();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Startup failed");
        }
    }
}