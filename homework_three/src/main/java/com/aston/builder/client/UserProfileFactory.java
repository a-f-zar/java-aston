package com.aston.builder.client;

import com.aston.builder.domain.model.UserProfile;

public class UserProfileFactory {

    public UserProfile createDefaultDeveloperProfile() {
        return UserProfile.builder("Ivan", "Ivanov")
                .age(25)
                .email("ivanov@example.com")
                .phone("+7 123 456 78 90")
                .address("Moscow, Russia")
                .jobTitle("Java Developer")
                .about("Java backend developer with microservices experience")
                .build();
    }
}