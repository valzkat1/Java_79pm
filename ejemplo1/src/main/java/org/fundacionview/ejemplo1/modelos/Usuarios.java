package org.fundacionview.ejemplo1.modelos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Usuarios {

	
	//POJO's
	
	@Size(min = 3,max = 100,message = "Minimo 3 letras en el nombre.")
	private String nombre;
	
	
	//@NotEmpty
	private String apellidos;
	
	@Min(value=18,message="Solo mayores de edad")
	@Max(value=110,message="Solo menores de 110")
	private int edad;
	
	
	//@Email(message = "Solo direcciones email con @")
	
	// Validar que el email sea solo de gmail
	@Pattern(regexp = "[a-zA-Z0-9]{1,30}^(@gmail.com)")
	private String email;
	
	
	
	private String telefono;
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
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
