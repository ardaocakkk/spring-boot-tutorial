package com.ocakarda.cruddemo;

import com.ocakarda.cruddemo.dao.StudentDAO;
import com.ocakarda.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		studentDAO.deleteAll();
		System.out.println("All students deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting the student with id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id:" + studentId);
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for (Student stu : theStudents) {
			System.out.println(stu);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for(Student stu: theStudents) {
			System.out.println(stu);
		}

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student newStudent = new Student("Eren", "Doe", "paul1@asd.com");
		Student newStudent2 = new Student("John", "Doe", "john1@asd.com");
		Student newStudent3 = new Student("Arda", "Doe", "arda1@asd.com");

		System.out.println("saving the students...");
		studentDAO.save(newStudent);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Paul", "Apple", "paul1@asd.com");
		studentDAO.save(newStudent);
		System.out.println("Saved student .. generated id :" + newStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("arda", "ocak", "ardaocak54@gmai.com");
		studentDAO.save(newStudent);
		System.out.println("Retrieving student with id:" + newStudent.getId());
		Student readStudent = studentDAO.findById(newStudent.getId());
		System.out.println(readStudent);
	}

}
