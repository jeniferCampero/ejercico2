package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	@Operation(summary="Crea una formación", 
			description="Crea una formación en los cursos")
	@PostMapping(value="formacion", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void crearFormacion(@Parameter(description="Crea una formación utilizando los datos recibidos como json")
								@RequestBody Formacion formacion) {
		formacionService.altaFormacion(formacion);
	}
	
	@Operation(summary="Busca las formaciones", 
			description="Devuelve las formaciones que hay en el catalogo")
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> buscarFormaciones(){
		return formacionService.buscarFormaciones();
	}
}
