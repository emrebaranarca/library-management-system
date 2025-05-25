package com.library.model;

import com.library.builder.StudentBuilder;
import com.library.builder.TeacherBuilder;
import com.library.builder.UserBuilder;
import com.library.enums.AccountType;

public class Teacher extends User {
    private String major;
    public Teacher(TeacherBuilder builder) {
        super(builder);
        this.major=builder.getMajor();
    }
    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return super.toString()+" major=" + major ;
    }
}
