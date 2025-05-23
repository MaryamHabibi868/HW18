package ir.maktabsharifhw18q02.hibernate.repository;
import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.entity.Student;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Set;

public class StudentRepositoryImp implements PersonRepository<Student> {

    EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    public StudentRepositoryImp() {
    }


    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student update(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    public List<Student> loadAll() {
        return entityManager.createQuery("from Student " ,
                Student.class).getResultList();
    }

    @Override
    public boolean contains(Student student) {
        return entityManager.contains(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
