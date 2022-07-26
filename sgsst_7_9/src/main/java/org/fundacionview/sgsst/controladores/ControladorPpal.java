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
import org.springframework.web.bind.annotation.RequestParam;

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
		
			Empleado e=repoEmple.consultarCC(a.getNumID());
			
			
		//	a.setNombre(null);
		//	a.setApellidos(null)
			a.setAreaTrabajo(e.getAreaTrabajo());
			a.setApellidos(e.getApellidos());
			a.setTipoID(e.getTipoID());
			
			
			double totales[]=calcularPagos(a.getTipoIncapacidad(), a.getTotalDias(), a.getSalarioDia());
			
			a.setValorARL(totales[1]);
			a.setValorEmpresa(totales[0]);
			a.setValorEPS(totales[2]);
			a.setValorPensiones(totales[3]);
			//			
			a.setDiagnostico(repoDiagnosticos.findByCodigo(a.getCodigoDiagnosti()).get());
			
			repoAusenti.save(a);
		return "redirect:/listar";
		}
	}
	

	public double[] calcularPagos(String tipoIncapacidad,int totalDias,double valorDias) {
		double[] valores=new double[4];  // 0= ValorEmpresa, 1= ValorARL, 2= ValorEPS, 3=ValorPensiones.
	
		
		
		if(tipoIncapacidad.equals("Enfermedad Comun")) {
			if(totalDias<3) {
				valores[0]=totalDias*valorDias;
				valores[1]=0.0;
				valores[2]=0.0;
				valores[3]=0.0;
				
			}else if(totalDias<=180) {
				
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=(totalDias-2)*valorDias*0.6667;
				valores[3]=0.0;
				
				
			}else if(totalDias<=540) {
				
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=(178)*valorDias*0.6667;
				valores[3]=(totalDias-180)*valorDias*0.5;
				
			}else {
				valores[0]=2*valorDias;
				valores[1]=0.0;
				valores[2]=((178)*valorDias*0.6667)+((totalDias-540)*valorDias*0.5);
				valores[3]=(540-180)*valorDias*0.5;
				
			}
			
			
			
			
			
		
		}else if(tipoIncapacidad.equals("Lic. Maternidad")) {
			
			valores[0]=0.0;
			valores[1]=0.0;
			valores[2]=totalDias*valorDias;
			valores[3]=0.0;
			
			
		
		}else if(tipoIncapacidad.equals("Lic. Paternidad")) {
			
			
			valores[0]=0.0;
			valores[1]=0.0;
			valores[2]=totalDias*valorDias;
			valores[3]=0.0;
			
			
		}else if(tipoIncapacidad.equals("Enfermedad Laboral")) {
			
			valores[0]=0.0;
			valores[1]=totalDias*valorDias;
			valores[2]=0.0;
			valores[3]=0.0;
			
			
		}else if(tipoIncapacidad.equals("Accidente de trabajo")) {
			valores[0]=0.0;
			valores[1]=totalDias*valorDias;
			valores[2]=0.0;
			valores[3]=0.0;
			
		}else if(tipoIncapacidad.equals("Fondo Pensiones")) {
			
			
			
		}else if(tipoIncapacidad.equals("Accedente de Transito")) {
			
			if(totalDias<3) {
				valores[0]=totalDias*valorDias;
				valores[1]=0.0;
				valores[2]=0.0;
				valores[3]=0.0;
			}else {
				valores[0]=2*valorDias;
				valores[1]=(totalDias-2)*valorDias*0.67;
				valores[2]=0.0;
				valores[3]=0.0;
			}
			
		}
				
		
		return valores;
	}
	
	
	@GetMapping("/listarIncapacidad")
	public String listarInca(Model mod) {
		
		mod.addAttribute("listaIncapacidades",repoAusenti.findAll());
		return "listarIncapacidad";
	}
	
	@GetMapping("/eliminarEmpleado")
	public String eliminarEmpleado(Model mod,@RequestParam("id")int id) {
		
		repoEmple.deleteById(id);
		
		return "redirect:/listar";
	}
	
	
	@GetMapping("/eliminarInc")
	public String eliminarInc(Model mod,@RequestParam("id")int id) {
		
		repoAusenti.deleteById(id);
		
		return "redirect:/listarIncapacidad";
	}
	
	
	@GetMapping("editarE")
	public String editarE(Model mod,@RequestParam("id")int id) {
		
		
		//mod.addAttribute("empleado",repoEmple.getById(id));
		
		mod.addAttribute("emp",repoEmple.getById(id));
		return "editarempleado";
	}
	
	
	@GetMapping("editarI")
	public String editarI(Model mod,@RequestParam("id")int id) {
		
		
		//mod.addAttribute("empleado",repoEmple.getById(id));
		mod.addAttribute("ausentismo",repoAusenti.findById(id).get());
		return "editarIncapacidad";
	}
	
	
	
}
