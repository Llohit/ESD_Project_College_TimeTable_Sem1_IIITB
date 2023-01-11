package com.example.demo.Bean;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name= "course")
public class Course {
    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(name="Cour_name")
    private String name;

    @Column(name="Specialization")
    private String specialization;

    @Column(name="Credits")
    private int credits;

    @Column(name="Term")
    private int term;


    @ManyToMany(mappedBy = "course") //Telling that mapping is done by course in Student Class(No extra table created) By Course
    private List<Student> student;   //Many to Many so list of students(key=MUL)

    public Course() {
    }

    public Course(int course_id , String name, String specialization, int credits, int term) {
        this.course_id = course_id;
        this.name = name;
        this.specialization= specialization;
        this.credits = credits;
        this.term = term;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id= course_id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }


    @Override
    public String toString() {
        return "Course{" +
                "CourseID=" + course_id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ",Credits='"+credits+'\'' +
                ", Term='" + term + '\'' +
                '}';
    }
}