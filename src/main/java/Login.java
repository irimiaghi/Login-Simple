import java.sql.SQLException;
import java.util.Scanner;

public class Login implements LoginCapable {
    private MySqlHandler sqlHandler;

    public Login() throws SQLException {
        sqlHandler = new MySqlHandler();
    }

    public boolean register() {
        String username;
        String password;
        String email;
        Scanner in = new Scanner(System.in);
        System.out.println("Username:");
        username = in.next();
        while (true) {
            System.out.println("Password:");
            password = in.next();
            System.out.println("Re-type password:");
            if (password.equals(in.next())) {
                break;
            } else {
                System.out.println("Passwords did not match!");
            }
        }
        System.out.println("Email address:");
        email = in.next();
        User x = new User(username, password, email);
        return sqlHandler.addUser(x);
    }

    public String login() {
        String username;
        String password;
        Scanner in = new Scanner(System.in);
        System.out.println("Username:");
        username = in.next();
        System.out.println("Password:");
        password = in.next();
        if (sqlHandler.loginUser(username, password)) {
            return username;
        } else {
            return null;
        }
    }

    public boolean logout() {
        System.out.println("You have logged out!");
        return true;
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        String username;

        while (!quit) {
            afisareMeniuPrincipal();
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Register menu");
                    register();
                    break;
                case 2:
                    boolean terminat = false;
                    System.out.println("Login menu");
                    while (true) {
                        username = login();
                        if (username != null) {
                            break;
                        } else {
                            System.out.println("Re-type your data:");
                        }
                    }
                    while (!terminat) {
                        afisareMeniuLogat();
                        System.out.print(username + ">" );
                        choice = in.nextInt();
                        switch (choice) {
                            case 1:
                                changePassword(username);
                                break;
                            case 2:
                                changeEmail(username);
                                break;
                            case 3:
                                terminat = logout();
                                break;
                            default:
                                System.out.println("Option unavailable");
                                break;
                        }
                    }
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Option unavailable");
                    afisareMeniuPrincipal();
                    break;
            }
        }
    }

    public void changePassword(String username) {
        String password;
        System.out.print(username + ">" );
        Scanner in = new Scanner(System.in);
        System.out.println("Type new password:");
        System.out.print(username + ">" );
        password = in.next();
        System.out.println("Re-type new password:");
        if (password.equals(in.next())) {
            sqlHandler.updatePassword(username, password);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Passwords did not match.");
        }
    }

    public void changeEmail(String username) {
        String email;
        Scanner in = new Scanner(System.in);
        System.out.println("Type your new email:");
        System.out.print(username + ">" );
        email = in.next();
        sqlHandler.updateEmail(username, email);
        System.out.println("Password changed successfully!");
    }

    private void afisareMeniuPrincipal() {
        System.out.println("Choose an option:");
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Exit");
    }

    private void afisareMeniuLogat() {
        System.out.println("1.Change password");
        System.out.println("2.Change email");
        System.out.println("3.Logout");
    }
}