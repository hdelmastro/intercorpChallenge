package com.intercorp.challenge.business.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
public class ClientWithDeathDTO extends ClientDTO{


    /*ClientWithDeathDTO(Long id, String name, String lastName, Integer age, LocalDate birthDate) {
        super(id, name, lastName, age, birthDate);
        this.dateOfDeath = dateOfDeath;
    }*/

    private LocalDate dateOfDeath;


}
