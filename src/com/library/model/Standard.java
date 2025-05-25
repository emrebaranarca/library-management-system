package com.library.model;

import com.library.builder.UserBuilder;
import com.library.enums.AccountType;

public class Standard extends User{
    public Standard(UserBuilder builder) {
        super(builder);
        builder.setAccountType(AccountType.STANDARD);
    }
}
