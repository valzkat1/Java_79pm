package org.fundacionview.sgsst.controladores;

import java.util.ArrayList;

import javax.validation.Valid;

import org.fundacionview.sgsst.modelos.CIE10;
import org.fundacionview.sgsst.modelos.Empleado;
import org.fundacionview.sgsst.repositorios.Repo_Cie10;
import org.fundacionview.sgsst.repositorios.Repo_Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorPpal {
	
	
	@Autowired
	Repo_Cie10 repoDiagnosticos;
	
	
	@Autowired
	Repo_Empleados repoEmple;
	
	
	
	@GetMapping("/")
	public String index() {
		
		
	/*	ArrayList<CIE10> listaDiagnosti=repoDiagnosticos.consultaAND();
		
		for(CIE10 d:listaDiagnosti) {		
			//System.out.println(d.toString());			
		}
		
		ArrayList<CIE10> listaDiagnosti2=repoDiagnosticos.consultaBETWEEN();
		for(CIE10 d:listaDiagnosti2) {		
			//System.out.println(d.toString());			
		}
		
		
		ArrayList<CIE10> listaDiagnosti3=repoDiagnosticos.consultaPorDiagnostico_Codigo("Z4");
		for(CIE10 d:listaDiagnosti3) {		
			System.out.println(d.toString());			
		}
		
		
		ArrayList<CIE10> listaDiagnosti4=repoDiagnosticos.consultarIN();
		for(CIE10 d:listaDiagnosti4) {		
			System.out.println("Consulta IN*** "+d.toString());			
		}
		*/
		
		return "index";
	}
	
	
	@GetMapping("/crear")
	public String formEmpleado(Model mod) {
		
		mod.addAttribute("emp",new Empleado());
		return "crearempleado";
	}
	
	
	@PostMapping("/crear_empleado")
	public String guardarEmpleado(@Valid @ModelAttribute("emp")Empleado e,Model mod,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearempleado";
		}else {
		
			
			repoEmple.save(e);
		return "redirect:/listar";
		}
	}
	
	
	@GetMapping("/listar")
	public String listar(Model mod) {
		
		mod.addAttribute("listaEmpleados",repoEmple.findAll());
		return "listar";
	}
	
	@GetMapping("/crearInc")
	public String crearIncapacidad() {
		return "crearIncapacidad";
	}
	

}
