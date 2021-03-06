package com.example.hevorestapi.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.hevorestapi.demo.entities.Course;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    // Constructor
    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(145, "Java", "Java is a programming language"));
        list.add(new Course(146, "Python", "Python is a programming language"));
        list.add(new Course(147, "C++", "C++ is a programming language"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {

        Course course = null;
        for (Course c : list) {
            if (c.getId() == courseId) {
                course = c;
                break;
            }
        }

        return course;
    }

    @Override
    public Course createCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        for (Course c : list) {
            if (c.getId() == parseLong) {
                list.remove(c);
                break;
            }
        }
    }

    @Override
    public Course updateCourse(long parseLong, Course course) {

        Course updatedCourse = null;
        for (Course c : list) {
            if (c.getId() == parseLong) {
                c.setName(course.getName());
                c.setDescription(course.getDescription());
                updatedCourse = c;
                break;
            }
        }

        return updatedCourse;
    }

}
