package com.curso.model;

public class Formacion {

	private String codigoCurso;
	private int asignaturas;
	private double precio;
	
	public Formacion(String codigoCurso, int asignaturas, double precio) {
		super();
		this.codigoCurso = codigoCurso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	public Formacion() {
		super();
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public int getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
