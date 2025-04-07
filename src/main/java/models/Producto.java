package models;

import java.sql.Date;
import java.text.DecimalFormat;

public class Producto {
    Integer idProducto;
    String codigo;
    String nombre;
    Double precio;
    String moneda;
    Integer stockActual;
    Integer stockMinimo;
    Date fechaCreacion;
    Integer idCategoria;
    String nombreCategoria;
    
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Integer getStockActual() {
		return stockActual;
	}
	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}
	public Integer getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
 
    
}
