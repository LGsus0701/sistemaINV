package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import models.Salida;

public interface SalidaMapper {
	List<Salida> listarSalidas();
	void registrarSalida(Salida salida);
	void actualizarStockProducto(@Param("idProducto") int idProducto, @Param("cantidad") int cantidad);


}
