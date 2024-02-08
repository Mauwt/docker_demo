package org.example.demo_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="users")
@Data
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {

    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;
}
