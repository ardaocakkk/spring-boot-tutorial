package com.ocakarda.cruddemo;

import com.ocakarda.cruddemo.dao.AppDAO;
import com.ocakarda.cruddemo.entity.Instructor;
import com.ocakarda.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
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
		int id = 1;
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
