package com.ocakarda.cruddemo;

import com.ocakarda.cruddemo.dao.AppDAO;
import com.ocakarda.cruddemo.entity.Course;
import com.ocakarda.cruddemo.entity.Instructor;
import com.ocakarda.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findCoursesForInstructor(appDAO);

//			findInstructorWithCoursesJoinFetch(appDAO);

//			updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteInstructor(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);

		course.setTitle("tester");

		appDAO.update(course);

		System.out.println("done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id =2;
		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setFirstName("tester");

		appDAO.update(instructor);


	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Associated courses: " + instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: "+ instructor);

		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourse(courses);

		System.out.println("The associated courses : " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		Course tempCourse1 = new Course("course-1");
		Course tempCourse2 = new Course("course-2");

		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		System.out.println("instructor: " + instructor);
		System.out.println("courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Susan", "Ocak", "susan@asd.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("asd.com","football");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("course-1");
		Course tempCourse2 = new Course("course-2");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println(tempInstructor.getCourses());

		appDAO.save(tempInstructor);

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstructorDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor " + tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {

//		Instructor tempInstructor = new Instructor("Chad", "Darb", "darb@asd.com");
//
//		InstructorDetail tempInstructorDetail = new InstructorDetail("asd.com","football");
//
//		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Instructor tempInstructor = new Instructor("Arda", "Ocak", "arda@asd.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("asd.com","football");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor" + tempInstructor);
		appDAO.save(tempInstructor);
	}

}
