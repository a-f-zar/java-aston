package com.aston;

import com.aston.domain.dto.ImmutableUser;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<String> roles = new ArrayList<>();
        roles.add("USER");

        ImmutableUser user = new ImmutableUser("John", roles);

        roles.add("ADMIN");

        System.out.println(user.getRoles());
    }
}
