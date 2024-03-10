package com.cibertec.ef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ef.models.Genero;
import com.cibertec.ef.repository.GeneroRepository;


@Service
public class GeneroService {
	
	@Autowired
	GeneroRepository categoryRepository;

	public List<Genero> findAll() {
        return categoryRepository.findAll();
    }
	
	public Optional<Genero> findById(Long id) {
		return categoryRepository.findById(id);
	}
}
