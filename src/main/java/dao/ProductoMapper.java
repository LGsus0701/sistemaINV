package dao;

import java.util.List;

import models.Producto;

public interface ProductoMapper {
	List<Producto> listarProductos();
	
	List<Producto> listarPorCategoria(int idCategoria);
	
}
