package com.ocakarda.cruddemo.dao;

import com.ocakarda.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);
}
