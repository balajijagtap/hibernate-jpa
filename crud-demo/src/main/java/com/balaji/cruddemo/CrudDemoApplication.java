package com.balaji.cruddemo;

import com.balaji.cruddemo.entity.Student;
import com.balaji.cruddemo.DAO.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO, 1);
			getStudents(studentDAO);
		};
	}

	private void getStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student student : studentList){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO, int id) {
		System.out.println("retrived student: " + studentDAO.readById(id));
	}

	private void createStudent(StudentDAO studentDAO){
		Student student = new Student("balaji", "jagtap", "balaji@gmail.com");
		studentDAO.save(student);
		System.out.println("generated id : " + student.getId());
	}
}
