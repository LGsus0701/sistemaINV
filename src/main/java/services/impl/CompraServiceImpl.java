package services.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.CompraMapper;
import models.Compra;
import services.CompraService;


public class CompraServiceImpl implements CompraService {
	
	@Override
	public List<Compra> listarCompras(){
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			CompraMapper compraMapper = session.getMapper(CompraMapper.class);
			List<Compra> compras = compraMapper.listarCompras();
			
			System.out.println("📌 compras obtenidos: " + compras.size());
			for (Compra c : compras) {
				System.out.println("➡ " + c.getIdCompra());
			}
			
			return compras;
			
		} catch (Exception e) {
			System.out.println("❌ Error en listarCompras: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
		}
	}
	
	@Override
	public void registrarCompra(Compra compra) {
	    try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	        CompraMapper mapper = session.getMapper(CompraMapper.class);
	        mapper.insertarCompra(compra);
	        session.commit();
	    } catch (Exception e) {
	        System.out.println("❌ Error al registrar compra: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


}
