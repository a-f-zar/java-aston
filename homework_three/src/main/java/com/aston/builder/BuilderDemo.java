package com.aston.builder;

import com.aston.builder.client.UserProfileFactory;
import com.aston.builder.domain.model.UserProfile;

public class BuilderDemo {

    public static void main(String[] args) {
        UserProfile profile1 = new UserProfile.Builder("Sergey", "Petrov")
                .age(28)
                .email("sergey.petrov@example.com")
                .jobTitle("QA Engineer")
                .build();

        UserProfile profile2 = new UserProfile.Builder("Anna", "Sidorova")
                .email("anna.sidorova@example.com")
                .phone("+7 900 123 45 67")
                .address("Moscow")
                .about("Manual and automation tester")
                .build();

        UserProfileFactory factory = new UserProfileFactory();
        UserProfile profile3 = factory.createDefaultDeveloperProfile();

        System.out.println(profile1);
        System.out.println();
        System.out.println(profile2);
        System.out.println();
        System.out.println(profile3);
    }
}