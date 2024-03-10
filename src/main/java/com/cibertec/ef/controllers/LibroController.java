package com.cibertec.ef.controllers;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.ef.models.Genero;
import com.cibertec.ef.models.Libro;
import com.cibertec.ef.services.GeneroService;
import com.cibertec.ef.services.LibroService;

@Controller
@RequestMapping("")
public class LibroController {

	@Autowired
	LibroService libroService;
	
	@Autowired
	GeneroService generoService;
	
	@GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("title", "Página de Inicio");
		model.addAttribute("libros", libroService.findAll());
		return "index";
	}
	
	@GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("genres", generoService.findAll());
        return "libro_form";
    }
	
	@PostMapping("/registro")
    public String registrarLibro(
    		@RequestParam("nombre") String nombre,
            @RequestParam("autor") String autor,
            @RequestParam("fechaPublicacion") String fechaPublicacion,
            @RequestParam("genero") Long generoId
    		) {
        
		
		Optional<Genero> genero = generoService.findById(generoId);
		 
		Libro libro = new Libro();
		libro.setNombre(nombre);
		libro.setAutor(autor);
		libro.setFechaPublicacion(LocalDate.parse(fechaPublicacion));
		libro.setGenero(genero.get());
        libroService.save(libro);
        return "redirect:/";
    }
	
	@PostMapping("/reporte")
	public void generarReporte() {
//		JasperReport jasperReport = JasperCompileManager.compileReport("reporte.jrxml");
//
//		// Llenar el reporte
//		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("titulo", "Reporte de libros");
//		List<Libro> libros = libroService.findAll();
//		JRDataSource dataSource = new JRBeanCollectionDataSource(libros);
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
//
//		// Generar el PDF
//		JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte.pdf");
	}
}
