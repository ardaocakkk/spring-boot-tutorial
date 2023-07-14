package com.ocakarda.cruddemo.dao;

import com.ocakarda.cruddemo.entity.Instructor;
import com.ocakarda.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
