package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		
		EntityManager manager = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(manager);
		
		Producto producto = productoDAO.consultaPorId(1l);
		
		System.out.println(producto.getNombre());
		
		BigDecimal precio = productoDAO.consultaPrecioPorNombreProducto("Xiaomi Redmi");
		System.out.println(precio);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager manager = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(manager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
		
		manager.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
