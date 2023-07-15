package com.ocakarda.cruddemo.dao;

import com.ocakarda.cruddemo.entity.Course;
import com.ocakarda.cruddemo.entity.Instructor;
import com.ocakarda.cruddemo.entity.InstructorDetail;
import com.ocakarda.cruddemo.entity.Student;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    public void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);
    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentsAndCourseByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
}
