package com.aston.domain.dto;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableUser {

    private final String name;
    private final List<String> roles;

    public ImmutableUser(String name, List<String> roles) {
        this.name = name;
        this.roles = new ArrayList<>(roles);
    }

    public String getName() {
        return name;
    }

    public List<String> getRoles() {
        return new ArrayList<>(roles);
    }
}
