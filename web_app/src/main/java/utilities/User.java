package utilities;

public class User {
    private String name;
    private String userName;
    private String password;

    Address address;

    private long id;


    public User(String name, String userName, String password, Address address) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public User(String name, String userName, String password, Address address, long id) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
