package com.aston.proxy.domain.model;

import com.aston.proxy.domain.enums.UserRole;

public class User {

    private final String name;
    private final UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }
}