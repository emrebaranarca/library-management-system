package com.library.model;

import com.library.builder.UserBuilder;
import com.library.enums.AccountStatus;
import com.library.enums.AccountType;

public class User {
    private final String identityNumber;
    private final String firstName;
    private final String lastName;
    //optional
    private String username;
    private String phoneNumber;
    private String email;
    private AccountType accountType;
    private AccountStatus accountStatus;



    public User(UserBuilder builder) {
        this.identityNumber=builder.getIdentityNumber();
        this.firstName=builder.getFirstName();
        this.lastName=builder.getLastName();
        this.username=builder.getUsername();
        this.phoneNumber=builder.getPhoneNumber();
        this.email=builder.getEmail();
        this.accountType=builder.getAccountType();
        this.accountStatus=builder.getAccountStatus();
    }

    // Getter
    public String getIdentityNumber() {
        return identityNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    @Override
    public String toString() {
        return "com.library.model.User{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                '}';
    }

}
