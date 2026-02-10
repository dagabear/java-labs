package kz.moderntech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kz.moderntech.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private double price;
}
