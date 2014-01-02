package com.daoleen.springlearning.jdbc.domain;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/30/13
 * Time: 3:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private Long id;
    private Long groupId;
    private String firstName;
    private String lastName;
    private Float age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }


    // Getters/Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }
}
