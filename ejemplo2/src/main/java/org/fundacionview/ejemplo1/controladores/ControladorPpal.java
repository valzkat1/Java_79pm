package org.fundacionview.ejemplo1.controladores;

import java.util.Locale;

import javax.validation.Valid;

import org.fundacionview.ejemplo1.modelos.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorPpal {
	
	@Autowired
	MessageSource mensajes;
	
	

	@GetMapping("/")
	public String crearEmpleado(Model mod) {
		
		Locale españa=new Locale("es","ES");
		Locale US = new Locale("en","US");
		
		String textonormal = mensajes.getMessage("textonormal", null, US);
		
		String textodinamico = mensajes.getMessage("textdinamico", new String[] {"Victor","Traducciones"},españa);
		
		mod.addAttribute("textonormal",textonormal);
		mod.addAttribute("textodinamico",textodinamico);
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
	
	
	@GetMapping("/login")
	public String login(Model mod) {
		
		
		mod.addAttribute("emp",new Empleado());
		return "index";
	}
	
	
	
	@PostMapping("/login")
	public String LoginEmple(Model mod,@Valid @ModelAttribute("emp")Empleado em,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "index";
		}else {
		    
			
			return "redirect:/";
		}
	}
	
	
}
