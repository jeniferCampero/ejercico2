package com.curso.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.curso.model.Formacion;

@Service
public interface FormacionService {

	
	List<Formacion> buscarFormaciones();
	void altaFormacion(Formacion formacion);
	
}
