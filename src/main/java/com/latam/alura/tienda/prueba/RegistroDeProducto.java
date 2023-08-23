package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono usado");
		celular.setPrecio(new BigDecimal("1000"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();		
		manager.persist(celular);
		manager.getTransaction().commit();
		manager.close();
		
	}

}
