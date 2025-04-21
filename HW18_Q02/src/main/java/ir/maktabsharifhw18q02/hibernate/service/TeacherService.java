package ir.maktabsharifhw18q02.hibernate.service;

import ir.maktabsharifhw18q02.hibernate.config.ApplicationContext;
import ir.maktabsharifhw18q02.hibernate.dto.TeacherDTO;
import ir.maktabsharifhw18q02.hibernate.entity.Teacher;
import ir.maktabsharifhw18q02.hibernate.repository.TeacherRepositoryImp;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;

import java.util.Set;

public class TeacherService {

    private final TeacherRepositoryImp teacherRepositoryImp;

    private final EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public TeacherService(TeacherRepositoryImp teacherRepositoryImp) {
        this.teacherRepositoryImp = teacherRepositoryImp;
        this.validator = validator;
    }

    public void signUp(TeacherDTO teacherDTO) {
        Set<ConstraintViolation<TeacherDTO>> constraintViolations = validator.validate(teacherDTO);

        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<TeacherDTO> constraintViolation : constraintViolations) {
                System.out.println("Error: " + constraintViolation.getMessage());
            }
            throw new ValidationException();
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setTeacherCode(teacherDTO.getTeacherCode());
        teacher.setDegree(teacherDTO.getDegree());
        teacher.setBirthday(teacherDTO.getBirthday());
        teacher.setLevelOfEducation(teacherDTO.getLevelOfEducation());
        teacher.setSalary(teacherDTO.getSalary());

        entityManager.getTransaction().begin();
        teacherRepositoryImp.save(teacher);
        entityManager.getTransaction().commit();
        System.out.println("Teacher added successfully");
    }
}
