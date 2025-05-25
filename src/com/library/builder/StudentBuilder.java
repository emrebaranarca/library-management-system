package com.library.builder;

import com.library.enums.AccountType;
import com.library.model.Student;

public class StudentBuilder extends UserBuilder<StudentBuilder> {
    private String school;
    public StudentBuilder(String identityNumber, String firstName, String lastName) {
        super(identityNumber, firstName, lastName);
        this.setAccountType(AccountType.STUDENT);
    }

    public StudentBuilder setSchool(String school) {
        this.school = school;
        return this;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public Student build(){
        return new Student(this);
    }


}
