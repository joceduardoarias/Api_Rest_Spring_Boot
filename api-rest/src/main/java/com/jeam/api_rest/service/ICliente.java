package com.jeam.api_rest.service;

import java.util.List;

import com.jeam.api_rest.model.entity.Cliente;

public interface ICliente {
	
	public List<Cliente> findAll();

	public Cliente findById(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Long id);
}
