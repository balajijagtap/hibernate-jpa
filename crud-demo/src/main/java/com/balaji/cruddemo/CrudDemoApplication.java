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
			//createStudent(studentDAO);
			//readStudent(studentDAO, 1);
			//getStudents(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO, 1);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int deletedCount = studentDAO.deleteAll();
		System.out.println(deletedCount + " rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO, int id) {
		getStudents(studentDAO);
		studentDAO.deleteStudent(id);
		System.out.println("after deleting ...");
		getStudents(studentDAO);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = readStudent(studentDAO, 1);
		student.setFirstName("bills");
		studentDAO.updateStudent(student);
		getStudents(studentDAO);
	}

	private void getStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student student : studentList){
			System.out.println(student);
		}
	}

	private Student readStudent(StudentDAO studentDAO, int id) {
		return studentDAO.readById(id);
	}

	private void createStudent(StudentDAO studentDAO){
		Student student = new Student("balaji", "jagtap", "balaji@gmail.com");
		studentDAO.save(student);
		System.out.println("generated id : " + student.getId());
	}
}
