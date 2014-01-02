package com.daoleen.springlearning.jdbc.domain;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/30/13
 * Time: 2:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Group {
    private Long id;
    private String name;
    private Date createdAt;

    private List<Student> students;

    @Override
    public String toString() {
        return "Group{" +
                "createdAt=" + createdAt +
                ", name='" + name + '\'' +
                '}';
    }


    // Getters/Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
