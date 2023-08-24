package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung", "Telefono usado", new BigDecimal("1000"), celulares);
		
		EntityManager manager = JPAUtils.getEntityManager();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
		ProductoDAO productoDAO = new ProductoDAO(manager);
		
		manager.getTransaction().begin();	
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
