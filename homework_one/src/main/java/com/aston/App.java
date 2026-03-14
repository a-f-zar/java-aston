package com.aston;

import com.aston.domain.dto.ImmutableUser;
import com.aston.domain.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);

        ImmutableUser user = new ImmutableUser("John", roles);

        roles.add(Role.ADMIN);

        System.out.println(user.getRoles());
    }
}
