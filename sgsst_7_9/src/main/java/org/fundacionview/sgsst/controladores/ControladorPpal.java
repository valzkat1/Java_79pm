package org.fundacionview.sgsst.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.fundacionview.sgsst.modelos.Ausentismo;
import org.fundacionview.sgsst.modelos.CIE10;
import org.fundacionview.sgsst.modelos.Empleado;
import org.fundacionview.sgsst.repositorios.Repo_Ausentismos;
import org.fundacionview.sgsst.repositorios.Repo_Cie10;
import org.fundacionview.sgsst.repositorios.Repo_Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorPpal {
	
	
	@Autowired
	Repo_Cie10 repoDiagnosticos;
	
	
	@Autowired
	Repo_Empleados repoEmple;
	
	
	@Autowired
	Repo_Ausentismos repoAusenti;
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
	
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
	public String crearIncapacidad(Model mod) {
		
		mod.addAttribute("ausentismo",new Ausentismo());
		return "crearIncapacidad";
	}
	
	
	@PostMapping("/crearIncapacidad")
	public String guardarIncapacidad(@Valid @ModelAttribute("ausentismo")Ausentismo a,Model mod,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearIncapacidad";
		}else {
		
			
			repoAusenti.save(a);
		return "redirect:/listar";
		}
	}
	

}
