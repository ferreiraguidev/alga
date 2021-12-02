package com.example.alga.model;

public class Customer {


    private String name;
    private String email;
    private String phone;
    private boolean ative = false;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAtive() {
        return ative;
    }


    public void ativar() {
        this.ative = true;
    }

}
