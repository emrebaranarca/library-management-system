package com.library.model;
import com.library.builder.StudentBuilder;

public class Student extends User {
    private String school;
    public Student(StudentBuilder builder)
    {
        super(builder);
        this.school=builder.getSchool();
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return super.toString()+" School: "+school;
    }
}
