package com.midominio.evaluable2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

	@ModelAttribute(name = "titular")
	String devuelveTitulo() {
		return "Biblioteca";
	}
	
	@GetMapping ("/inicio")
	public String home(Model model) {
	model.addAttribute("titulo", "Biblioteca Municipal de Dos Hermanas");
	model.addAttribute("cabecera", "Bienvenidos a la biblioteca");
		return "home/home";
	}
	
}
