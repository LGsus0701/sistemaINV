package services.impl;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.CompraMapper;
import dao.SalidaMapper;
import models.Compra;
import models.Salida;
import services.SalidaService;

public class SalidaServiceImpl implements SalidaService {
	
	@Override
	public List<Salida> listarSalidas(){
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
			SalidaMapper salidaMapper = session.getMapper(SalidaMapper.class);
			List<Salida> salidas = salidaMapper.listarSalidas();
			
			System.out.println("📌 salidas obtenidos: " + salidas.size());
			for (Salida s : salidas) {
				System.out.println("➡ " + s.getIdSalida());
			}
			
			return salidas;
			
		} catch (Exception e) {
			System.out.println("❌ Error en listarSalidas: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
		}
	}
	
	@Override
	public boolean registrarSalida(Salida salida) {
		try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
			SalidaMapper salidaMapper = session.getMapper(SalidaMapper.class);
			
			// Registrar salida
			salidaMapper.registrarSalida(salida);
			
			// Actualizar stock del producto
			salidaMapper.actualizarStockProducto(salida.getIdProducto(), salida.getCantidad());

			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
