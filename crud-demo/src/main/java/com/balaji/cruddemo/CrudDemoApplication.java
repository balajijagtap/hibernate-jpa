package com.balaji.cruddemo;

import com.balaji.cruddemo.entity.Student;
import com.balaji.cruddemo.DAO.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		Student student = new Student("balaji", "jagtap", "balaji@gmail.com");
		studentDAO.save(student);
		System.out.println("generated id : " + student.getId());
	}

}
