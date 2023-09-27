package com.alemaTruck.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.sound.midi.Patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alemaTruck.models.entity.TipoVehiculos;
import com.alemaTruck.models.entity.Vehiculos;
import com.alemaTruck.models.service.ITipoVehiculoService;
import com.alemaTruck.models.service.IVehiculoService;
import com.alemaTruck.util.Utilerias;





@Controller
@RequestMapping("/views/vehiculos")
public class VehiculoController {
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/")
	public String listarVehiculos(Model model) {
	
		
		List<Vehiculos> listadoVehiculos = vehiculoService.listarTodos();
		
		model.addAttribute("titulo", "Listado de Vehiculo");
		model.addAttribute("vehiculos", listadoVehiculos);
		
		return "/views/vehiculos/listar";
		
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Vehiculos vehiculo = new Vehiculos();
		List<TipoVehiculos> listTipoVehiculos = tipoVehiculoService.listaTipoVehiculos();
		
		model.addAttribute("titulo", "Formulario: Nuevo Vehiculo");
		model.addAttribute("vehiculos", vehiculo);
		model.addAttribute("tipovehiculos", listTipoVehiculos);
		
		return "/views/vehiculos/frmCrear";
		
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Vehiculos vehiculos,
			              @RequestParam("file") 
	                     MultipartFile imagen) {
		
		if (!imagen.isEmpty()) {
			String ruta= "c:/vehiculos/img-vehiculos/";
			String nombreImagen = Utilerias.guardarArchivo(imagen,ruta);
			if (nombreImagen != null) {
				//Procesamos la variable nombre de la imagen
				vehiculos.setImagen(nombreImagen);
			}
		}
		
		
		/*
		 * if (!imagen.isEmpty()) { Patch directorioImagenes = (Patch)
		 * Paths.get("src//main//resources//static/images"); String rutaAbsoluta =
		 * ((Path) directorioImagenes).toFile().getAbsolutePath();
		 * 
		 * try { byte[] bytesImg = imagen.getBytes(); Patch rutaCompleta = (Patch)
		 * Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
		 * Files.write(rutaCompleta, bytesImg);
		 * 
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		
		
		
		
		
		
		vehiculoService.guardar(vehiculos);
		System.out.println("Vehículo guardado con éxito!");
		return "redirect:/views/vehiculos/";
		
		
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleVehiculo( @PathVariable("id") 
	                    Integer idVehiculo,
			              Model model) {
		
		Vehiculos vehiculo = vehiculoService.buscarPorId(idVehiculo);
		
		List<TipoVehiculos> listTipoVehiculos = tipoVehiculoService.listaTipoVehiculos();
		
		model.addAttribute("titulo", "Detalle del vehiculo:"+ vehiculo.getMarca());
		model.addAttribute("vehiculos", vehiculo);
		model.addAttribute("tipovehiculos", listTipoVehiculos);
		
		System.out.println("Vehículo actualizado con éxito!");
		return "/views/vehiculos/detalleVehiculo";
		
		
	}
	
	
	
	
	

	@GetMapping("/edit/{id}")
	public String editar( @PathVariable("id") 
	                    Integer idVehiculo,
			              Model model) {
		
		Vehiculos vehiculo = vehiculoService.buscarPorId(idVehiculo);
		
		List<TipoVehiculos> listTipoVehiculos = tipoVehiculoService.listaTipoVehiculos();
		
		model.addAttribute("titulo", "Formulario: Editar Vehiculo");
		model.addAttribute("vehiculos", vehiculo);
		model.addAttribute("tipovehiculos", listTipoVehiculos);
		
		System.out.println("Vehículo actualizado con éxito!");
		return "/views/vehiculos/frmCrear";
		
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar( @PathVariable("id") 
	                    Integer idVehiculo ) {
		
		vehiculoService.eliminar(idVehiculo);
		
		System.out.println("Vehículo eliminado con éxito!");
		return "redirect:/views/vehiculos/";
		
		
	}
}































