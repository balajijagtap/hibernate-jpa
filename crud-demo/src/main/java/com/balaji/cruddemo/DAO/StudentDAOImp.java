package com.balaji.cruddemo.DAO;

import com.balaji.cruddemo.DAO.StudentDAO;
import com.balaji.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        this.entityManager.persist(student);
    }

    @Override
    public Student readById(int id){
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = this.entityManager.createQuery("From Student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = readById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
