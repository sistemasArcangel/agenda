package com.app.appagenda.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Lob
	@Column(name = "fotografia")
	private String fotografia;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "rol_idrol")
	private Integer rolIdrol;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRolIdrol() {
		return rolIdrol;
	}

	public void setRolIdrol(Integer rolIdrol) {
		this.rolIdrol = rolIdrol;
	}

	

	
}