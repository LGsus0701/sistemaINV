package services.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.CategoriaMapper;
import models.Categoria;
import services.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {
	
	public List<Categoria> listarCategorias() {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			CategoriaMapper categoriaMapper = session.getMapper(CategoriaMapper.class);
			List<Categoria> categorias = categoriaMapper.listarCategorias();
			
			System.out.println("📌 Categorías obtenidas: " + categorias.size());
			for (Categoria c : categorias) {
				System.out.println("➡ " + c.getIdCategoria() + " - " + c.getNombre());
			}
			
			return categorias;
		} catch (Exception e) {
			System.out.println("❌ Error en listarCategorias: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
		}
		
	}
	public void insertarCategoria(Categoria categoria) {
		
	}

}
