package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioVenta {

	private String nombreProducto;
	private Long cantidad;
	private LocalDate fechaUltimaVenta;
	
	public RelatorioVenta() {}

	public RelatorioVenta(String nombreProducto, Long cantidad, LocalDate fechaUltimaVenta) {
		super();
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFechaUltimaVenta() {
		return fechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioVenta [nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", fechaUltimaVenta="
				+ fechaUltimaVenta + "]";
	}
}
