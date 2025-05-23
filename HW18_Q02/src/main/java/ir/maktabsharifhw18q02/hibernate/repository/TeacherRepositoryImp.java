package ir.maktabsharifhw18q02.hibernate.repository;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.entity.Teacher;
import jakarta.persistence.EntityManager;

import java.util.List;


public class TeacherRepositoryImp implements
        PersonRepository<Teacher> {

    EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    public TeacherRepositoryImp() {
    }

    @Override
    public Teacher save(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    @Override
    public void delete(Teacher teacher) {
        entityManager.remove(teacher);
    }

    @Override
    public List<Teacher> loadAll() {
        return entityManager.createQuery("from Teacher",
                Teacher.class).getResultList();
    }

    @Override
    public boolean contains(Teacher teacher) {
        return entityManager.contains(teacher);
    }

    @Override
    public Teacher findById(Integer id) {
        return entityManager.find(Teacher.class, id);
    }
}
