package com.midominio.evaluable2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.app.dao.LibroRepository;
import com.midominio.evaluable2.app.entity.Libro;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public Iterable<Libro> dameLaLista () {
		return libroRepository.findAll();

	}
	
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
	}

}
