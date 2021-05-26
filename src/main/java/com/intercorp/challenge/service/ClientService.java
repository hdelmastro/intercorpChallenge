package com.intercorp.challenge.service;

import com.intercorp.challenge.business.model.ClientDTO;
import com.intercorp.challenge.business.model.ClientKpiDTO;
import com.intercorp.challenge.business.model.ClientWithDeathDTO;
import com.intercorp.challenge.persistence.dao.IClientDao;
import com.intercorp.challenge.persistence.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    private static final DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Autowired
    private IClientDao clientDao;

    @Autowired
    private IStatisticService statisticService;


    public void createClient(ClientDTO client) {

        Client entity = Client.builder()
                .age(client.getAge())
                .birthDate(client.getBirthDate())
                .lastName(client.getLastName())
                .name(client.getName())
                .build();

        clientDao.save(entity);

        statisticService.calculateStatitstics(client);
    }

    public List<ClientDTO> getClients() {

        List<Client> clients = clientDao.findAll();

        List<ClientDTO> response = clients.stream().map(cl -> ClientWithDeathDTO.builder()
                .age(cl.getAge())
                .birthDate(cl.getBirthDate())
                .id(cl.getId())
                .name(cl.getName())
                .lastName(cl.getLastName())
                .dateOfDeath(statisticService.getDateOfDeath(cl, clients))
                .build()
        ).collect(Collectors.toList());

        return response;
    }

    @Override
    public ClientKpiDTO getClientsKpi() {

        List<Client> clients = clientDao.findAll();

        ClientKpiDTO response = ClientKpiDTO.builder()
                .ageAverage(statisticService.getAgeAverage())
                .ageStandardDeviation(statisticService.solveStandardDeviation(clients))
                .build();

        return response;
    }







}
