package ir.maktabsharifhw18q02.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString (callSuper = true)
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends Person{

    @Column(nullable = false , unique = true , length = 10)
    private String studentCode;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private Integer yearOfEntry;
}
