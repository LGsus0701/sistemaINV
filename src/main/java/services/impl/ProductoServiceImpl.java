package services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import dao.ProductoMapper;
import models.Producto;
import services.ProductoService;
import config.MyBatisUtil;

public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<Producto> listarProductos() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
            List<Producto> productos = productoMapper.listarProductos();
            return (productos != null) ? productos : List.of(); // Evita null
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }
    
    
}

