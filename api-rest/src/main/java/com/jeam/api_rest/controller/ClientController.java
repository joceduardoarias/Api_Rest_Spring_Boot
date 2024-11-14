package com.jeam.api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jeam.api_rest.model.entity.Cliente;
import com.jeam.api_rest.service.ICliente;

@RestController // Define l clase como un controlador REST
@RequestMapping("/api/v1") // Define a ruta del controlador
public class ClientController {

	@Autowired
	private ICliente clientService;
	
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createClient(@RequestBody Cliente client) {
		return clientService.save(client);
	}
	
	@GetMapping("/cliente")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Cliente> getClients() {
		return clientService.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente getClient(@PathVariable Long id) {
		return clientService.findById(id);
	}
	
	@PutMapping("/cliente")
	public Cliente updateClient(@RequestBody Cliente client) {
		return clientService.save(client);
	}
	
	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable Long id) {
		clientService.delete(id);
	} 
}
