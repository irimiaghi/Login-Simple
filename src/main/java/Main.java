import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            DemoLogin app = new DemoLogin();
            app.register(createUser());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Startup failed!");
        }
         // try/catch for Duplicate entries
        //Menu with Swtich / Case
        //Inainte de logare doar Register si Login
        //Dupa logare doar Logout
    }
    public static User createUser () {
        Scanner input = new Scanner(System.in); // test@test.com testuser testpass
        System.out.println("Welcome to the Register menu!");
        System.out.print("Enter a valid email: ");
        String email = input.next();
        System.out.print("Enter a unique username: ");
        String username = input.next();
        System.out.print("Enter a secure password: ");
        String password = input.next();
        User user = new User(email, username, password);
        return user;
    }
}
