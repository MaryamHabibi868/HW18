package ir.maktabsharifhw18q02.hibernate.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {

    @NotBlank (message = "First name should be entered")
    private String firstName;

    @NotBlank (message = "Last name should be entered")
    private String lastName;

    @NotNull(message = "Birth date should be entered")
    @Past (message = "Date of birthday should be in the past")
    private LocalDate birthday;

    @Size (min = 10, max = 10 , message = "Student code should have 10 numbers")
    private String studentCode;

    @NotBlank (message = "Major should be entered")
    private String major;

    @Pattern(regexp = "\\d{4}" , message = "Year of entry should have 4 number")
    private Integer yearOfEntry;
}
