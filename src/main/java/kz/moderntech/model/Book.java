package kz.moderntech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.moderntech.model.base.BaseEntity;
import lombok.*;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book extends BaseEntity {

    private String title;
    private String author;
    private int year;

}
