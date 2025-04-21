package ir.maktabsharifhw18q02.hibernate.config;

import ir.maktabsharifhw18q02.hibernate.repository.StudentRepositoryImp;
import ir.maktabsharifhw18q02.hibernate.repository.TeacherRepositoryImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApplicationContext {

    private static ApplicationContext applicationContext;
    private ApplicationContext() {
    }


    public static ApplicationContext getInstance(){
        if(applicationContext == null){
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }


    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }


    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if(entityManager == null){
            entityManager = getEntityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    private StudentRepositoryImp studentRepository;
    public StudentRepositoryImp getStudentRepository() {
        if(studentRepository == null){
            studentRepository = new StudentRepositoryImp();
        }
        return studentRepository;
    }

    private TeacherRepositoryImp teacherRepository;

    public TeacherRepositoryImp getTeacherRepository() {
        if(teacherRepository == null){
            teacherRepository = new TeacherRepositoryImp();
        }
        return teacherRepository;
    }

}
