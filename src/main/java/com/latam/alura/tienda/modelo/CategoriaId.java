package com.latam.alura.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre, contrasenia;

	public CategoriaId() {
	}
	
	public CategoriaId(String nombre, String contrasenia) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasenia, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		return Objects.equals(contrasenia, other.contrasenia) && Objects.equals(nombre, other.nombre);
	}
	
	
}
