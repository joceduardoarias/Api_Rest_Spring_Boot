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
import com.jeam.api_rest.model.entity.dto.ClienteDto;
import com.jeam.api_rest.model.entity.payload.MensajeResponse;
import com.jeam.api_rest.service.ICliente;

@RestController // Define l clase como un controlador REST
@RequestMapping("/api/v1") // Define a ruta del controlador
public class ClientController {

	@Autowired
	private ICliente clientService;
	
	@PostMapping("/cliente")	
	public ResponseEntity<?> createClient(@RequestBody ClienteDto clientDto) {				 
		try {
			
			Cliente cliente = clientService.save(clientDto);
			ClienteDto clienteDto = ClienteDto.builder()
					.idCliente(cliente.getIdCliente())
					.nombre(cliente.getNombre())
					.apellido(cliente.getApellido())
					.correo(cliente.getCorreo())
					.fechaRegistro(cliente.getFechaRegistro())
					.build();
			
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje("Guardado correctamente")
					.data(clientDto)
					.build(), HttpStatus.CREATED);
			
		} catch (DataAccessException ex) {
			
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(ex.getMessage())
					.data(null)
					.build()
					, HttpStatus.METHOD_NOT_ALLOWED);
		}
			
	}
	
	@GetMapping("/cliente")	
	public ResponseEntity<?> getClients() {			
		try {
			return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
		} catch (DataAccessException ex) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(ex.getMessage())
					.data(null)
					.build()
					, HttpStatus.INTERNAL_SERVER_ERROR);
		}				
	}
	
	@GetMapping("/cliente/{id}")	
	public ResponseEntity<?> getClient(@PathVariable Long id) {
				
		try {
            Cliente cliente = clientService.findById(id);
            if (cliente == null) {                
                return new ResponseEntity<>(MensajeResponse.builder()
                		.mensaje("El cliente con el id ".concat(id.toString().concat(" no existe en la base de datos")))
                		.data(null)
                		.build(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        } catch (DataAccessException ex) {
        	            
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(ex.getMessage())
					.data(null)
					.build(),
					HttpStatus.INTERNAL_SERVER_ERROR);
        }				
	}
	
	@PutMapping("/cliente/{id}")
	public ResponseEntity<?> updateClient(@RequestBody ClienteDto clienteDto, @PathVariable Long id) {				
		try {
			Cliente clienteOld = clientService.findById(id);
			if (clienteOld == null) {				
				return new ResponseEntity<>(MensajeResponse.builder()
                		.mensaje("El cliente con el id ".concat(id.toString().concat(" no existe en la base de datos")))
                		.data(null)
                		.build(), HttpStatus.METHOD_NOT_ALLOWED);				
			}
			clienteDto.setIdCliente(id);
			clientService.save(clienteDto);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataAccessException ex) {
			return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(ex.getMessage())
					.data(null)
					.build(),
					HttpStatus.METHOD_NOT_ALLOWED);
		}		
	}
	
	@DeleteMapping("/cliente/{id}")	
	public ResponseEntity<?> deleteClient(@PathVariable Long id) {		
		try {
			Cliente  cliente = clientService.findById(id);	
			if (cliente == null) {
				 return new ResponseEntity<>(MensajeResponse.builder()
	                		.mensaje("El cliente con el id ".concat(id.toString().concat(" no existe en la base de datos")))
	                		.data(null)
	                		.build(), HttpStatus.NOT_FOUND);
			}
			
            clientService.delete(id);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex) {
        	return new ResponseEntity<>(MensajeResponse.builder()
					.mensaje(ex.getMessage())
					.data(null)
					.build(),
					HttpStatus.METHOD_NOT_ALLOWED);
        }            
	} 
}
