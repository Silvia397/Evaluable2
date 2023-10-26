package com.midominio.evaluable2.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.app.dao.UsuarioRepository;
import com.midominio.evaluable2.app.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Iterable<Usuario> dameLaLista() {
		return usuarioRepository.findAll();
		
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario save (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findById (Long id) {
		return usuarioRepository.findById(id);
	}

}
