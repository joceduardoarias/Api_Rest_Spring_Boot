package com.jeam.api_rest.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@ToString
@Builder // Usamos el patrón builder para crear objetos de esta clase.
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	@Id
	@Column(name = "idCliente")
	private Long idCliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "correo")
	private String correo;
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	public Cliente() {
	}

	public Cliente(Long id, String nombre, String apellido, String correo) {
		this.idCliente = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setId(Long id) {
		this.idCliente = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setEmail(String correo) {
		this.correo = correo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
