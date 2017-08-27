package com.caysever.java8.model;

public class Person {
    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private Long birthday;

    public Person(String firstname, String lastname, String gender, Integer age, Long birthday) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", age=" + age + ", birthday=" + birthday + "]";
    }

}
