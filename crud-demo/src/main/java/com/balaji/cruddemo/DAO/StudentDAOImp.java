package com.balaji.cruddemo.DAO;

import com.balaji.cruddemo.DAO.StudentDAO;
import com.balaji.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImp implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student){
        this.entityManager.persist(student);
    }
}
