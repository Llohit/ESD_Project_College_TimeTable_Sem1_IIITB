package com.example.demo.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Studtable")
public class Studtable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    int id;
    @Column(name ="course_id",nullable = false)
    int course_id;

    @Column(name ="course_name",nullable = false)
    String course_name;

    @Column(name ="faculty_name",nullable = false)
    String faculty_name;

    @Column(name ="room")
    int room;

    @Column(name ="specialization")
    String specialization;

    @Column(name ="lecture_no")
    int lecture_no;

    public Studtable(int id, int course_id, String course_name, String faculty_name, int room, String specialization, int lecture_no) {
        this.id = id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.faculty_name = faculty_name;
        this.room = room;
        this.specialization = specialization;
        this.lecture_no = lecture_no;
    }


    public Studtable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getLecture_no() {
        return lecture_no;
    }

    public void setLecture_no(int lecture_no) {
        this.lecture_no = lecture_no;
    }
    @Override
    public String toString() {
        return "\nStudtable{" +
                "id=" + id +
                ", course_id='" +course_id + '\'' +
                "course_name=" + course_name +
                ", faculty_name='" + faculty_name + '\'' +
                "room=" + room +
                ",specialization ='" + specialization + '\'' +
                ", \nlecture_no=" + lecture_no +
                '}';
    }
}
