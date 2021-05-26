package com.intercorp.challenge.business.controller;

import com.intercorp.challenge.business.model.ClientDTO;
import com.intercorp.challenge.business.model.ClientKpiDTO;
import com.intercorp.challenge.persistence.entity.Client;
import com.intercorp.challenge.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/intercorp")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<String> createClient(@RequestBody ClientDTO client){
        clientService.createClient(client);
        return new ResponseEntity<String>("created", HttpStatus.CREATED);
    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<ClientKpiDTO> createClient(){
        ClientKpiDTO response = clientService.getClientsKpi();
        return new ResponseEntity<ClientKpiDTO>(response , HttpStatus.OK);
    }

    @GetMapping("/listclientes")
    public ResponseEntity<List<ClientDTO>> listClients(){
        List<ClientDTO> response = clientService.getClients();
        return new ResponseEntity<List<ClientDTO>>(response , HttpStatus.OK);
    }

}
