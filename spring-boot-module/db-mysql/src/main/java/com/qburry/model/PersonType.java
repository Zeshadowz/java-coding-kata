package com.qburry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person_type",
        uniqueConstraints = @UniqueConstraint(name = "UQ_PersonType_Name", columnNames = "name")
)
public class PersonType {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

}