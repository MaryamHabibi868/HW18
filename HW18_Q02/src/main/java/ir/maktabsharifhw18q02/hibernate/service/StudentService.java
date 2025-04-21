package ir.maktabsharifhw18q02.hibernate.service;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.entity.Student;
import ir.maktabsharifhw18q02.hibernate.repository.StudentRepositoryImp;
import jakarta.persistence.EntityManager;

public class StudentService {
    private final StudentRepositoryImp studentRepositoryImp;

    private final EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    public StudentService(StudentRepositoryImp studentRepositoryImp) {
        this.studentRepositoryImp = studentRepositoryImp;
    }

    public void signUp(Student student) {
        studentRepositoryImp.save(student);
    }
}
