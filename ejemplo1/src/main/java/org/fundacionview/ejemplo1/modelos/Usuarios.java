package org.fundacionview.ejemplo1.modelos;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Usuarios {

	
	@Size(min = 3,max = 100,message = "Minimo 3 letras en el nombre.")
	private String nombre;
	private String apellidos;
	private int edad;
	private String email;
	private Date fechaNaci;
	
	
	
	public Usuarios() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNaci() {
		return fechaNaci;
	}
	public void setFechaNaci(Date fechaNaci) {
		this.fechaNaci = fechaNaci;
	}
	
	
	
	
}