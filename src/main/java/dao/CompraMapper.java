package dao;

import java.util.List;

import models.Compra;

public interface CompraMapper {
	List<Compra> listarCompras();
	void insertarCompra(Compra compra);
	void actualizarStockPorCompra(int idCompra);


}
