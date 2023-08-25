package com.latam.alura.tienda.prueba;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager manager = JPAUtils.getEntityManager();
		
		manager.getTransaction().begin();	
		
		manager.persist(celulares);
		
		celulares.setNombre("LIBROS");
		
		manager.flush();
		manager.clear();
		
		celulares =  manager.merge(celulares);
		celulares.setNombre("SOFTWARE");
		
		manager.flush();
		manager.clear();
		celulares = manager.merge(celulares);
		manager.remove(celulares);
		manager.flush();
		
	}

}
