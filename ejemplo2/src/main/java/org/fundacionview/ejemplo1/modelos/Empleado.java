package org.fundacionview.ejemplo1.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.fundacionview.ejemplo1.validaciones.Confirmar_Email;
import org.fundacionview.ejemplo1.validaciones.Email_Gmail;
import org.fundacionview.ejemplo1.validaciones.Indicativo_Colombia;

@Entity
@Table(name = "tbl_empleado")
@Confirmar_Email(groups = {ValidacionesEmpleado.class})
public class Empleado {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 1,max=10,groups = {ValidacionesEmpleado.class})	
	@NotBlank(groups = {ValidacionesEmpleado.class})
	private String nombre;
	
	@NotBlank(groups = {ValidacionesEmpleado.class})
	private String tipoID;
	
	
	private int id_user;

	@Email_Gmail(groups = {ValidacionesEmpleado.class})
	@Size(min=3,groups = {ValidacionesLogin.class})
	private String email;
	
	// validar que las direcciones de correo coincidan.
	private String confirmarEmail;
	
	// +57-xxxxxxxxx
	// Crear validacion propia para recibir numeros con indicativo de colombia.
	// Con validaciones propias o con
	// @Patter
	
	@Indicativo_Colombia(groups = {ValidacionesEmpleado.class})
	private String telefono;
	
	
	@Size(min=5,groups = {ValidacionesLogin.class,ValidacionesEmpleado.class})
	private String clave;
	
	
	
	

	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getConfirmarEmail() {
		return confirmarEmail;
	}


	public void setConfirmarEmail(String confirmarEmail) {
		this.confirmarEmail = confirmarEmail;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipoID() {
		return tipoID;
	}


	public void setTipoID(String tipoID) {
		this.tipoID = tipoID;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public Empleado() {
		super();
	}
	
	
	
	
	
}
