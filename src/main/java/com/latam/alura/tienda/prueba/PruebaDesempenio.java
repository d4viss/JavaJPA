package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;

public class PruebaDesempenio {

	public static void main(String[] args) throws FileNotFoundException {
		LoadRecords.cargarRegistros();
		
		EntityManager manager = JPAUtils.getEntityManager();
		
		PedidoDAO pedidoDAO = new PedidoDAO(manager);
		Pedido pedido = pedidoDAO.consultarPedidoConCliente(2l);
		
		manager.close();
		
		System.out.println(pedido.getCliente().getNombre());
		
		//System.out.println(pedido.getItems().size());
	}
}
