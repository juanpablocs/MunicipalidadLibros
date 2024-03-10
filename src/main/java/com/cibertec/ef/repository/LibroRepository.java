package com.cibertec.ef.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.ef.models.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {

}
