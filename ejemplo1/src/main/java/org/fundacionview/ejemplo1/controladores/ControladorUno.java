package org.fundacionview.ejemplo1.controladores;

import javax.validation.Valid;

import org.fundacionview.ejemplo1.modelos.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUno {
	
	
	
	// DAO
	
	@GetMapping("/")
	public String index(Model mod) {
		
		mod.addAttribute("usuarios",new Usuarios());
		return "index";
	}
	
	
	@GetMapping("/login")
	public String login( Model mod ) {
		return "login";
	}
	
	
	
	@PostMapping("/guardar")
	public String envioForm(Model mod,@Valid @ModelAttribute("usuarios")Usuarios u,BindingResult rv) {
		
		if(rv.hasErrors()) {
			return "index";
		}else {
			return "menu";
		}
		
		
	}
	

}
