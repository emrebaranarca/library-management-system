package com.library.builder;

import com.library.enums.AccountType;
import com.library.model.Teacher;

public class TeacherBuilder extends UserBuilder<TeacherBuilder>{
    private String major;

    public TeacherBuilder(String identityNumber, String firstName, String lastName) {
        super(identityNumber, firstName, lastName);
        this.setAccountType(AccountType.TEACHER);
    }

    public TeacherBuilder setMajor(String major) {
        this.major = major;
        return this;
    }


    public String getMajor() {
        return major;
    }

    @Override
    public Teacher build() {
        return new Teacher(this);
    }
}
