package org.fundacionview.sgsst.controladores;

import java.util.ArrayList;

import org.fundacionview.sgsst.modelos.CIE10;
import org.fundacionview.sgsst.repositorios.Repo_Cie10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis")
public class ControladorAPIS {

	
	@Autowired
	Repo_Cie10 repoDiagnos;
	
	@GetMapping("/diagnosticos")
	public ArrayList<CIE10> getDiagnosticos(@RequestParam("texto")String texto){
		
		ArrayList<CIE10> listado= repoDiagnos.consultaPorDiagnostico_Codigo(texto);
		return listado;
		
	}
	
}
