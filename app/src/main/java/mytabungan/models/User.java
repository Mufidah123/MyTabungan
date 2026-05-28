package mytabungan.models;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    // Constructor untuk login
    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Constructor untuk register
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
