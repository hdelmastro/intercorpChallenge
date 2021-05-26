package com.intercorp.challenge.persistence.dao;

import com.intercorp.challenge.persistence.entity.Client;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClientDao extends CrudRepository<Client, Long> {
    List<Client> findAll();

}
