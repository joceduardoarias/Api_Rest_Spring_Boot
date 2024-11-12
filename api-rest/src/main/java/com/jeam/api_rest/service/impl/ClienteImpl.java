package com.jeam.api_rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeam.api_rest.model.entity.Cliente;
import com.jeam.api_rest.model.entity.dao.ClienteDao;
import com.jeam.api_rest.service.ICliente;

public class ClienteImpl implements ICliente {
	
	// Inyectamos el ClienteDao para poder usar sus métodos
	// esto se hace con la anotación @Autowired. La otra forma de hacerlo
	// es con el constructor, pero en este caso usaremos la anotación.
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
