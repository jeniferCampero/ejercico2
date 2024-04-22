package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoDatos;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;	
	
	private String url = "http://localhost:8080/";
	
	@Override
	public List<Formacion> buscarFormaciones() {
		CursoDatos[] cursoDatosList = template.getForObject(url+"cursos", CursoDatos[].class);
		List<Formacion> formacionList = new ArrayList<>(cursoDatosList.length);
		
		for (int i=0; i < cursoDatosList.length; i++) {
			CursoDatos cursoDatos = cursoDatosList[i];
			double precio = (double)cursoDatos.getPrecio();
			String codigoCurso = (cursoDatos.getNombre().substring(0,3)).concat(
								String.valueOf(cursoDatos.getDuracion()));
			int asignaturas = 5;
			if(cursoDatos.getDuracion() >= 50) {
				asignaturas = 10;
			}
			
			Formacion formacion = new Formacion(codigoCurso,asignaturas, precio);
			formacionList.add(formacion);
		}
		
		return formacionList;
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		CursoDatos cursoDatos = new CursoDatos(
									formacion.getCodigoCurso(),
									formacion.getCodigoCurso().substring(0, 3), 
									formacion.getAsignaturas()*10, 
									(int)formacion.getPrecio());
		template.postForLocation(url+"curso", cursoDatos);	

	}
}
