package com.library.model.params;

public class UserCreationParams {
    private final String identityNumber;
    private final String firstName;
    private final String lastName;
    //optional
    private final String username;
    private final String phoneNumber;
    private final String email;


    public UserCreationParams(
            String identityNumber, String firstName, String lastName,
            String username, String phoneNumber, String email) {
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
