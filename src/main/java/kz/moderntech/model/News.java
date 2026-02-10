package kz.moderntech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.moderntech.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class News extends BaseEntity {
    private String title;
    private String content;
    private boolean published;
}
