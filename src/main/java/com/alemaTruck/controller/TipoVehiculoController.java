package com.alemaTruck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alemaTruck.models.entity.TipoVehiculos;
import com.alemaTruck.models.entity.Vehiculos;
import com.alemaTruck.models.service.ITipoVehiculoService;

@Controller
@RequestMapping("/views/tipovehiculos")
public class TipoVehiculoController {
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;
	
	@GetMapping("/")
	public String listarTipoProductos(Model model) {
		
		List<TipoVehiculos> listadoTipoVehiculos = tipoVehiculoService.listarTodos();
		model.addAttribute("titulo", listadoTipoVehiculos);
		model.addAttribute("tipovehiculos", listadoTipoVehiculos);
				
		return "/views/tipovehiculos/listar";
		}
		
	@GetMapping("/create")
	public String crear(Model model) {
		TipoVehiculos tipovehiculos = new TipoVehiculos();
		
		model.addAttribute("titulo", "Formulario: Nuevo Tipovehiculo");
		model.addAttribute("tipovehiculos", tipovehiculos);
		
		return "/views/tipovehiculos/frmCrear";
		
	}
	
	@PostMapping("/save")
	public String  guardar(@ModelAttribute TipoVehiculos tipoVehiculos) {
		
		tipoVehiculoService.guardar(tipoVehiculos);
		System.out.println("Guardado Tipo Vehiculo con éxito!");
		return "redirect:/views/tipovehiculos/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") 
	                     Integer idTipovehiculo, 
			                         Model model) {
		TipoVehiculos tipovehiculos = tipoVehiculoService.buscarPorId(idTipovehiculo);
		
		model.addAttribute("titulo", "Formulario:Editar Tipovehiculo");
		model.addAttribute("tipovehiculos", tipovehiculos);
		
		System.out.println("Registro Editado con éxito!");
		return "/views/tipovehiculos/frmCrear";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eleminar(@PathVariable("id") 
	                       Integer idTipovehiculo )
			                          {
		tipoVehiculoService.eliminar(idTipovehiculo);
		System.out.println("Registro Eliminado  con éxito!");
			return "redirect:/views/tipovehiculos/";
		
	}
	

}
















