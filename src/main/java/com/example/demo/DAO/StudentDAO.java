package com.example.demo.DAO;

import com.example.demo.Bean.Course;
import com.example.demo.Bean.Student;
import com.example.demo.Bean.Studtable;

import java.util.List;

public interface StudentDAO {

    boolean addStudent(Student student);
    Student roll_numberVerify(Student student);

    List<Studtable> getCourse(Student student);

    Student getStudentByID(Integer id);
}