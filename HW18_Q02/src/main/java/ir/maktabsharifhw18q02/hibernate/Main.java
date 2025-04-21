package ir.maktabsharifhw18q02.hibernate;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.dto.StudentDTO;
import ir.maktabsharifhw18q02.hibernate.dto.TeacherDTO;
import ir.maktabsharifhw18q02.hibernate.service.StudentService;
import ir.maktabsharifhw18q02.hibernate.service.TeacherService;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

import static ir.maktabsharifhw18q02.hibernate.entity.LevelOfEducation.PHD;


public class Main {
    public static void main(String[] args) {


        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

        StudentService studentService = new StudentService(
                ApplicationContext.getInstance().getStudentRepository());

        TeacherService teacherService = new TeacherService(
                ApplicationContext.getInstance().getTeacherRepository());

        // Add Student
        StudentDTO student = new StudentDTO();
        student.setFirstName("Ali");
        student.setLastName("Sharif");
        student.setBirthday(LocalDate.of(2000, 1, 1));
        student.setStudentCode("1234567891");
        student.setMajor("IT");
        student.setYearOfEntry(2020);

        studentService.signUp(student);

        // Add Teacher
        TeacherDTO teacher = new TeacherDTO();
        teacher.setFirstName("Maryam");
        teacher.setLastName("Habibi");
        teacher.setBirthday(LocalDate.of(1990, 5, 1));
        teacher.setTeacherCode("9876543219");
        teacher.setDegree("Professor Science");
        teacher.setLevelOfEducation(PHD);
        teacher.setSalary(35.00);

        teacherService.signUp(teacher);


    }
}