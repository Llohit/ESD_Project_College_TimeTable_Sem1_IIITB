package com.example.demo.Bean;

import jakarta.persistence.*;
import java.io.Serializable;

import java.util.*;

@Entity
@Table(name = "Student")
public class Student implements Serializable{
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;
    @Column(name = "roll_number",nullable = false, unique = true)
    private String roll_number;


    @ManyToMany(fetch= FetchType.EAGER) //Will by default load ALL of the relationships
    @JoinTable(name = "Student_Courses", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> course;


    public Student() {
    }

    public Student(int student_id,String first_name, String last_name, String roll_number) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.roll_number = roll_number;
    }


    public Integer getStudent_id() {
        return student_id;
    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }


    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    // to string to print object as a string otherwise it returns object Hashcode
    @Override
    public String toString() {
        return "Student{" +
                "employeeID=" + student_id +
                ", employeeName='" + first_name + '\'' +
                ", employeeGender='" + roll_number + '\'' +
                '}';
    }
}