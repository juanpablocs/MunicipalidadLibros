package com.cibertec.ef.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "genero")
    private List<Libro> libros;
    
    // ... getters y setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}