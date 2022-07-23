package com.todeb.bkolay.usedvehiclesaleapplication.model.entity;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String surname;
    private String about;
    private String email;

    @OneToMany(mappedBy = "persons", cascade = CascadeType.MERGE)
    private List<Product> products;
}
