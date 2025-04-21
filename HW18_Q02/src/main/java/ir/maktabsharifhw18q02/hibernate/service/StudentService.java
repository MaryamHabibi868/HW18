package ir.maktabsharifhw18q02.hibernate.service;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.dto.StudentDTO;
import ir.maktabsharifhw18q02.hibernate.entity.Student;
import ir.maktabsharifhw18q02.hibernate.repository.StudentRepositoryImp;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;

import java.util.Set;

public class StudentService {
    private final StudentRepositoryImp studentRepositoryImp;

    private final EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    public StudentService(StudentRepositoryImp studentRepositoryImp) {
        this.studentRepositoryImp = studentRepositoryImp;
        this.validator = validator;
    }

    public void signUp(StudentDTO studentDTO) {
        Set<ConstraintViolation<StudentDTO>> constraintViolations =
                validator.validate(studentDTO);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<StudentDTO> constraintViolation : constraintViolations) {
                System.out.println("Error: " + constraintViolation.getMessage());
            }
            throw new ValidationException();
        }
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setStudentCode(studentDTO.getStudentCode());
        student.setMajor(studentDTO.getMajor());
        student.setYearOfEntry(studentDTO.getYearOfEntry());
        student.setBirthday(studentDTO.getBirthday());

        entityManager.getTransaction().begin();
        studentRepositoryImp.save(student);
        entityManager.getTransaction().commit();

        System.out.println("Student added successfully");
    }
}
