package ir.maktabsharifhw18q02.hibernate.dto;

import ir.maktabsharifhw18q02.hibernate.entity.LevelOfEducation;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherDTO {

    @NotBlank(message = "First name should be entered")
    private String firstName;

    @NotBlank(message = "Last name should be entered")
    private String lastName;

    @NotNull(message = "Birth date should be entered")
    @Past(message = "Date of birthday should be in the past")
    private LocalDate birthday;

    @Size(min = 10, max = 10, message = "Teacher code should have 10 numbers")
    private String teacherCode;

    @NotBlank(message = "Degree should be entered")
    private String degree;

    @NotBlank(message = "Level of education should be entered")
    private LevelOfEducation levelOfEducation;

    @Positive
    @Digits(integer = 10, fraction = 2)
    private Double salary;
}
