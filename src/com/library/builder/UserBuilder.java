package com.library.builder;

import com.library.enums.AccountStatus;
import com.library.enums.AccountType;
import com.library.model.User;

public class UserBuilder<T extends UserBuilder<T>> {
    private final String identityNumber;
    private final String firstName;
    private final String lastName;
    //optional
    private String username;
    private String phoneNumber;
    private String email;
    private AccountType accountType;
    private AccountStatus accountStatus;


    // mandatory variable
    public UserBuilder(String identityNumber, String firstName, String lastName) {
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountStatus = AccountStatus.ACTIVE;
    }

    public T self() {
        return (T) this;
    }

    public T setUsername(String username) {
        this.username = username;
        return self();
    }

    public T setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return self();
    }

    public T setEmail(String email) {
        this.email = email;
        return self();
    }

    public T setAccountType(AccountType accountType) {
        this.accountType = accountType;
        return self();
    }

    public T setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return self();
    }

    //created object
    public User build() {
        return new User(this);
    }

    public User studentBuild(){
        this.accountType = AccountType.STUDENT;
        return new User(this);
    }

    public User standardBuild(){
        this.accountType = AccountType.STANDARD;
        return new User(this);
    }

    public User teacherBuild(){
        this.accountType = AccountType.TEACHER;
        return new User(this);
    }

    // Getter metodları
    public String getIdentityNumber() { return identityNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public AccountType getAccountType() { return accountType; }
    public AccountStatus getAccountStatus() { return accountStatus; }

}
