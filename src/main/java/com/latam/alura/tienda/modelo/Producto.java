package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	private Long id;
	private String name, descripcion;
	private BigDecimal precio;
}
