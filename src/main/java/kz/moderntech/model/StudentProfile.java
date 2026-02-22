package kz.moderntech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.moderntech.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "student_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile extends BaseEntity {

    private String address;
    private String phone;
    private LocalDate birthDate;

}
