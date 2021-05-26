package com.intercorp.challenge.business.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
public class ClientDTO {

    public ClientDTO(Long id, String name, String lastName, Integer age, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;

}
