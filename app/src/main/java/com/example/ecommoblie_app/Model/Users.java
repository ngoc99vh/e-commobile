package com.example.ecommoblie_app.Model;

public class Users {
    private String userName, phone, password, fullName, address;

    public Users(String userName, String phone, String password, String fullName, String address) {
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
    }

    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
