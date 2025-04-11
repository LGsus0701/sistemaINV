package models;

import java.sql.Date;

public class Salida {
	private Integer idSalida;
	private Date fechaSalida;
	private Date fechaCreacion;
	private Integer idUsuario;
	private String usuarioUsuario;
	private Integer idOrdenTrabajo;
	private String codigoOT;


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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuarioUsuario() {
		return usuarioUsuario;
	}
	public void setUsuarioUsuario(String usuarioUsuario) {
		this.usuarioUsuario = usuarioUsuario;
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
	

}
