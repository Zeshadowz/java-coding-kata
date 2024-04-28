package com.qburry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "person",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_Person_Email", columnNames = "email"),
                @UniqueConstraint(name = "UQ_Person_Phone", columnNames = "phone")
        }
)
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_type", nullable = false, foreignKey = @ForeignKey(name = "FK_Person_PersonType"))
    private PersonType personType;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

}