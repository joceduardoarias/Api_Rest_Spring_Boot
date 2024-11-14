package com.jeam.api_rest.model.entity.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data // Lombok genera los getters y setters
@ToString
@Builder // Lombok genera un patrón de diseño Builder
@NoArgsConstructor // Agrega un constructor sin argumentos
@AllArgsConstructor // Agrega un constructor con todos los argumentos
public class ClienteDto implements Serializable {
		
	private Long idCliente;	
	private String nombre;	
	private String apellido;	
	private String correo;	
	private Date fechaRegistro;	
		
}
