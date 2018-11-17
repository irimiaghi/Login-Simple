public interface LoginCapable {
    public boolean register();
    public String login();
    public boolean logout();
    public void changePassword(String x);
    public void changeEmail(String x);

}