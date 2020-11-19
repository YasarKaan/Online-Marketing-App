package User;

public abstract class User  {
    protected String username;
    protected String password;
    protected double balance;

    public User(String username, String password, double balance) {
        this.username=username;
        this.password= password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){return password;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
