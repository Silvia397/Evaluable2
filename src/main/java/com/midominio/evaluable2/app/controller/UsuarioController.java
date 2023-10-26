package com.midominio.evaluable2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.midominio.evaluable2.app.entity.Usuario;
import com.midominio.evaluable2.app.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public String catalogoUsuarios (Model model) {
		model.addAttribute("titulo", "Catálogo de usuarios");
		model.addAttribute("catalogo", usuarioService.dameLaLista());
			return "usuario/lista-usuario";
			
	}
	
	@GetMapping("/usuarios/borrar/{id}")
	public String borrarLibro (@PathVariable Long id ) {
		usuarioService.deleteById(id);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/crear")
	public String muestraFormularioVacio(Model model) {
		model.addAttribute("titulo", "Crear usuario");
		model.addAttribute("cabecera", "Formulario");
		model.addAttribute("usuario", new Usuario());
			return "usuario/form";
	}
	
	@PostMapping("usuarios/form")
	public String guardaFormulario (Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("usuarios/form/{id}")
	public String muestraFormularioConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.findById(id));
		model.addAttribute("titulo", "Editar formulario");
		model.addAttribute("cabecera", "Formulario");
		return"usuario/form";
	}
}
