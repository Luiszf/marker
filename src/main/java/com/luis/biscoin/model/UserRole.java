package com.luis.biscoin.model;

public enum UserRole {
    PAGEADMIN("pageadmin"),
    COSTUMER("costumer");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
