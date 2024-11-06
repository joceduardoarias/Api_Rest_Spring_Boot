package com.jeam.api_rest.model.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.jeam.api_rest.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
