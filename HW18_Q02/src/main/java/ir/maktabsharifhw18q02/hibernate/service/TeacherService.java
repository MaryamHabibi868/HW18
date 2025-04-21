package ir.maktabsharifhw18q02.hibernate.service;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.entity.Teacher;
import ir.maktabsharifhw18q02.hibernate.repository.TeacherRepositoryImp;
import jakarta.persistence.EntityManager;

public class TeacherService {

   private final TeacherRepositoryImp teacherRepositoryImp;

   private final EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    public TeacherService(TeacherRepositoryImp teacherRepositoryImp) {
        this.teacherRepositoryImp = teacherRepositoryImp;
    }

    public void signUp(Teacher teacher) {
        teacherRepositoryImp.save(teacher);
    }
}
