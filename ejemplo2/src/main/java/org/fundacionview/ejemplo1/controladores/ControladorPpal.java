package org.fundacionview.ejemplo1.controladores;

import javax.validation.Valid;

import org.fundacionview.ejemplo1.modelos.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorPpal {

	@GetMapping("/")
	public String crearEmpleado(Model mod) {
		
		mod.addAttribute("emp",new Empleado());
		return "crearempleado";
	}
	
	
	@PostMapping("/crear_empleado")
	public String crearEmple(Model mod,@Valid @ModelAttribute("emp")Empleado em,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "crearempleado";
		}else {
		    
			
			return "index";
		}
	}
	
	
	@RequestMapping("/pagina1")
	public String index() {
		return "index";
		
	}
	
	
	
}
