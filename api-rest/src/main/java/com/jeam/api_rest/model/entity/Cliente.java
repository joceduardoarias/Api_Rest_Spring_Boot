package com.jeam.api_rest.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;


@ToString
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

	public Cliente(Long id, String nombre, String apellido, String email) {
		this.idCliente = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = email;
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

	public String getEmail() {
		return correo;
	}

	public void setEmail(String email) {
		this.correo = email;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
