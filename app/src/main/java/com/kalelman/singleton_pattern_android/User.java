package com.kalelman.singleton_pattern_android;

public class User {

    private String name;
    private String email;
    private String password;

    private static User user = new User();

    private User() {
        name = "Erick Rojas";
        email = "erick_rojas_perez@hotmail.com";
        password = "12345678";
    }

    public static User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return name + ", " + email;
    }
}
