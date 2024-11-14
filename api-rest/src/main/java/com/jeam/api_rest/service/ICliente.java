package com.jeam.api_rest.service;

import java.util.List;

import com.jeam.api_rest.model.entity.Cliente;
import com.jeam.api_rest.model.entity.dto.ClienteDto;

public interface ICliente {
	
	public List<Cliente> findAll();

	public Cliente findById(Long id);

	public Cliente save(ClienteDto cliente);

	public void delete(Long id);
}
