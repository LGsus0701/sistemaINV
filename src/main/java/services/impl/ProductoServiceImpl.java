package services.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import dao.CategoriaMapper;
import dao.ProductoMapper;
import models.Categoria;
import models.Producto;
import services.ProductoService;
import config.MyBatisUtil;
import services.impl.ProveedorServiceImpl;

public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<Producto> listarProductos() {
    	try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
			List<Producto> productos = productoMapper.listarProductos();
			
			System.out.println("📌 productos obtenidos: " + productos.size());
			for (Producto p : productos) {
				System.out.println("➡ " + p.getIdProducto() + " - " + p.getNombre());
			}
			
			return productos;
		} catch (Exception e) {
			System.out.println("❌ Error en listarProductos: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
		}
    }
    
 // Método para listar productos por categoría
    public List<Producto> listarPorCategoria(int idCategoria) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductoMapper productoMapper = session.getMapper(ProductoMapper.class);
            List<Producto> productosPorCategoria = productoMapper.listarPorCategoria(idCategoria);
            
            System.out.println("📌 productos obtenidos para categoría " + idCategoria + ": " + productosPorCategoria.size());
            for (Producto p : productosPorCategoria) {
                System.out.println("➡ " + p.getIdProducto() + " - " + p.getNombre());
            }
            
            return productosPorCategoria;
        } catch (Exception e) {
            System.out.println("❌ Error en listarProductosPorCategoria: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

