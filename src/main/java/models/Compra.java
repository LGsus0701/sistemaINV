package models;

import java.sql.Date;

public class Compra {
    private int idCompra;
    private int idProveedor;
    private String nombreComercial; // de tabla proveedor
    private int idProducto;
    private String nombreProducto;  // de tabla productos
    private int cantidad;
    private Double precioUnd;   // para dinero, mejor BigDecimal
    private Double subtotal;
    private Double total;
    private String estadoAuditoria;
    private Date fechaAuditoria;
    
    
 // Getters y Setters
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioUnd() {
		return precioUnd;
	}
	public void setPrecioUnd(Double precioUnd) {
		this.precioUnd = precioUnd;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getEstadoAuditoria() {
		return estadoAuditoria;
	}
	public void setEstadoAuditoria(String estadoAuditoria) {
		this.estadoAuditoria = estadoAuditoria;
	}
	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}
	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

    

    
}

	
