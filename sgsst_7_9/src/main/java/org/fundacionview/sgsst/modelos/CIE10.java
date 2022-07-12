package org.fundacionview.sgsst.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosticos_cie10")
public class CIE10 {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codigo;
	
	private String diagnostico;
	
	private String grupo_dx;
	
	private String seg_osteomuscular;
	
	private String origen;
	
	
}
