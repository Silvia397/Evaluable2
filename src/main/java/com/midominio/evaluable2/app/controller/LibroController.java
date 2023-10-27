package com.midominio.evaluable2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.midominio.evaluable2.app.entity.Libro;
import com.midominio.evaluable2.app.service.LibroService;

@Controller
public class LibroController {
	
	@Autowired
	LibroService libroService;
		
	/*@ModelAttribute(name = "titular")
	String devuelveTitulo() {
		return "Biblioteca";
	}*/
	
	@GetMapping("/catalogo")
	public String catalogoLibros(Model model) {
		model.addAttribute("titulo", "Catálogo de libros");
		model.addAttribute("catalogo", libroService.dameLaLista());
		return "libro/catalogo";
		
	}
	
	@GetMapping("/catalogo/borrar/{id}")
	public String borrarLibro (@PathVariable Long id ) {
		libroService.deleteById(id);
		return "redirect:/catalogo";
	}
	
	@GetMapping("/catalogo/crear")
	public String muestraFormulario(Model model) {
		model.addAttribute("titulo", "Crear libro");
		model.addAttribute("cabecera", "Formulario");
		model.addAttribute("libro", new Libro());
			return "libro/form";
	}
	
	@PostMapping("catalogo/form")
	public String guardaFormulario (Libro libro) {
		libroService.save(libro);
		return "redirect:/catalogo";
	}
	
	@GetMapping("catalogo/form/{id}")
	public String muestraFormularioConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("libro", libroService.findById(id));
		model.addAttribute("titulo", "Editar formulario");
		model.addAttribute("cabecera", "Formulario");
			return "libro/form";
	}
	
	@GetMapping("catalogo/filtrar/{autor}")
	public String findByAutor(@PathVariable String autor, Model model){
		model.addAttribute("catalogo", libroService.findByAutor(autor));
			return "libro/catalogo";
			
	}

}
