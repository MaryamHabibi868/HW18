package ir.maktabsharifhw18q02.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends Person{

    @Column(nullable = false , unique = true , length = 10)
    private String teacherCode;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LevelOfEducation levelOfEducation;


    private Double salary;

    public Teacher(String teacherCode, String degree,
                   LevelOfEducation levelOfEducation, Double salary) {
        this.teacherCode = teacherCode;
        this.degree = degree;
        this.levelOfEducation = levelOfEducation;
        this.salary = salary;
    }
}
