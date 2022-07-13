package org.fundacionview.sgsst.controladores;

import java.util.ArrayList;

import org.fundacionview.sgsst.modelos.CIE10;
import org.fundacionview.sgsst.repositorios.Repo_Cie10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPpal {
	
	
	@Autowired
	Repo_Cie10 repoDiagnosticos;
	
	
	@GetMapping("/")
	public String index() {
		
		
		ArrayList<CIE10> listaDiagnosti=repoDiagnosticos.consultaAND();
		
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
		
		
		return "index";
	}
	

}
