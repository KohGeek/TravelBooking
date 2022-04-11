package travel.domain;

public class User {

    private String username;
    private String password;

    // constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter
    public String getUsername() {
        return username;
    }

    // getter
    public String getPassword() {
        return password;
    }

}
