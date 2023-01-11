package com.example.demo.DAO;

import com.example.demo.Bean.Course;

import java.util.List;

public interface CourseDAO {
    boolean addCourse(Course course);

    boolean registerCourse(Course course);

    List<Course> getCourses();

    Course getCourseByID(Integer id);


}
