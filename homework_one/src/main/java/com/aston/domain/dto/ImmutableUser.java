package com.aston.domain.dto;

import com.aston.domain.enums.Role;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableUser {

    private final String name;
    private final List<Role> roles;

    public ImmutableUser(String name, List<Role> roles) {
        this.name = name;
        this.roles = List.copyOf(roles);
    }

    public String getName() {
        return name;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
