package com.aston.builder.domain.model;

public class UserProfile {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String phone;
    private final String address;
    private final String jobTitle;
    private final String about;

    private UserProfile(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.jobTitle = builder.jobTitle;
        this.about = builder.about;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public static Builder builder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String email;
        private String phone;
        private String address;
        private String jobTitle;
        private String about;

        private  Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder about(String about) {
            this.about = about;
            return this;
        }

        public UserProfile build() {
            validate();
            return new UserProfile(this);
        }

        private void validate() {
            if (firstName == null || firstName.isBlank()) {
                throw new IllegalArgumentException("First name cannot be blank");
            }
            if (lastName == null || lastName.isBlank()) {
                throw new IllegalArgumentException("Last name cannot be blank");
            }
        }
    }
}