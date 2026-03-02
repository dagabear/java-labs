package kz.moderntech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.moderntech.model.base.CreateEntity;
import kz.moderntech.model.dto.StudentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends CreateEntity {

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private short age;

    public StudentResponseDto toDto() {
        return new StudentResponseDto(
                this.firstName,
                this.lastName,
                this.email,
                this.age,
                this.getCreatedDate()
        );
    }

}
