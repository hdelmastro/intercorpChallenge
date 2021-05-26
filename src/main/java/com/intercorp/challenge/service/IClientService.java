package com.intercorp.challenge.service;

import com.intercorp.challenge.business.model.ClientDTO;
import com.intercorp.challenge.business.model.ClientKpiDTO;

import java.time.LocalDate;
import java.util.List;

public interface IClientService {

    void createClient(ClientDTO client);

    List<ClientDTO> getClients();

    ClientKpiDTO getClientsKpi();
}


