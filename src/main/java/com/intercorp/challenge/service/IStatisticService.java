package com.intercorp.challenge.service;

import com.intercorp.challenge.business.model.ClientDTO;
import com.intercorp.challenge.persistence.entity.Client;

import java.time.LocalDate;
import java.util.List;

public interface IStatisticService {

    void calculateStatitstics(ClientDTO client);
    Double solveStandardDeviation(List<Client> clients);
    Double getAgeAverage();

    LocalDate getDateOfDeath(Client cl, List<Client> clients);
}
