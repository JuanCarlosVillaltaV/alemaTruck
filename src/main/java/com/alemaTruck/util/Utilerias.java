package com.alemaTruck.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utilerias {
	
	public static String guardarArchivo(MultipartFile imagen, String ruta) {
		//Se obtiene el nombre original del archivo
		String nombreOriginal = imagen.getOriginalFilename();
		
		try {
			//Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta+ nombreOriginal);
			System.out.println("Archivo" + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			imagen.transferTo(imageFile);
		return nombreOriginal;
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error"+ e.getMessage());
			return null;
		}		

	}

}
