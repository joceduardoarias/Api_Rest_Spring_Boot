package com.jeam.api_rest.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> deleteClient(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente  cliente = clientService.findById(id);	
			if (cliente == null) {
				response.put("mensaje",
						"El cliente con el id ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
            clientService.delete(id);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex) {
        	response.put("mensaje", "Error al eliminar el cliente en la base de datos");
            response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }            
	} 
}
