package models;

import java.sql.Date;

public class Salida {
	private Integer idSalida;
	private Date fechaSalida;
	private Date fechaCreacion;
	private Integer idOrdenTrabajo;
	private String codigoOT;
	private Integer cantidad;
	private Integer idProducto;
	private String nombreProducto;
	
	
	public Integer getIdSalida() {
		return idSalida;
	}
	public void setIdSalida(Integer idSalida) {
		this.idSalida = idSalida;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getIdOrdenTrabajo() {
		return idOrdenTrabajo;
	}
	public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
		this.idOrdenTrabajo = idOrdenTrabajo;
	}
	public String getCodigoOT() {
		return codigoOT;
	}
	public void setCodigoOT(String codigoOT) {
		this.codigoOT = codigoOT;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	

}