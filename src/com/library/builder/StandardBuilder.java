package com.library.builder;

import com.library.enums.AccountType;
import com.library.model.Standard;
import com.library.model.User;

public class StandardBuilder extends UserBuilder<StandardBuilder>{

    public StandardBuilder(String identityNumber, String firstName, String lastName) {
        super(identityNumber, firstName, lastName);
        this.setAccountType(AccountType.STANDARD);
    }

    @Override
    public Standard build() {
        return new Standard(this);
    }
}
