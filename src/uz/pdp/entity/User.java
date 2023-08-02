package uz.pdp.entity;

import uz.pdp.enums.UserType;

import java.util.UUID;

public class User {
    {
        uuid=UUID.randomUUID();
    }
    UUID uuid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private UserType userType;

    public User() {
//        uuid=UUID.randomUUID();
    }

    public User(String username, String password, String phone, String email, UserType userType) {
//        uuid=UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userType=userType;
    }

    public UUID getUuid() {
        return uuid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
