package com.studentmanagement.model;


public class StudentDTO {

    private String phoneNumber;
    private String name;
    private String age;
    private String classDiv;
    private String rollNo;

    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassDiv() {
        return classDiv;
    }

    public void setClassDiv(String classDiv) {
        this.classDiv = classDiv;
    }
}
