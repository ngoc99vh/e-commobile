package com.example.ecommoblie_app.Model;

public class Products {
    private int Id;
    private String Name, Role;

    public Products() {
    }

    public Products(int id, String name, String role) {
        Id = id;
        Name = name;
        Role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
