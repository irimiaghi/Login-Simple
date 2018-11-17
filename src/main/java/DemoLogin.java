import java.sql.SQLException;

public class DemoLogin implements LoginCapable {
    private MySqlHandler sqlHandler;
    public DemoLogin() throws SQLException {
        this.sqlHandler = new MySqlHandler();
    }
    public boolean register(User x) {
        return sqlHandler.addUser(x);
    }
    public boolean login() {
        return false;
    }
    public boolean logout() {
        return false;
    }
}
