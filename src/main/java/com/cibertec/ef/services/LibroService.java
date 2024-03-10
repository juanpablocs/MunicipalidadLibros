package com.cibertec.ef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ef.models.Libro;
import com.cibertec.ef.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	LibroRepository libroRepository;

	public List<Libro> findAll() {
        return libroRepository.findAll();
    }
	
	public Optional<Libro> findById(Long id) {
		return libroRepository.findById(id);
	}
	
	public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }
}
