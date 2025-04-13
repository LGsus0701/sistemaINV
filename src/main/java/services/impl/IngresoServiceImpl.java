package services.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.IngresoMapper;
import models.Ingreso;
import services.IngresoService;
import dao.CompraMapper;


public class IngresoServiceImpl implements IngresoService {
	
	@Override
	public List<Ingreso> listarIngresos() {
	    try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	        IngresoMapper ingresoMapper = session.getMapper(IngresoMapper.class);
	        List<Ingreso> ingresos = ingresoMapper.listarIngresos();
	        System.out.println("📌 ingresos obtenidos: " + ingresos.size());
	        for (Ingreso i : ingresos) {
	            System.out.println("➡ " + i.getIdIngreso());
	        }

	        return ingresos; // ← ESTA LÍNEA ES NECESARIA
	    } catch (Exception e) {
	        System.out.println("❌ Error en listarIngresos: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}
	
	
	@Override
	public void insertarIngreso(Ingreso ingreso) {
	    try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	        IngresoMapper ingresoMapper = session.getMapper(IngresoMapper.class);
	        ingresoMapper.insertarIngreso(ingreso);

	        // Actualizar el stock de productos relacionados con esta compra
	        CompraMapper compraMapper = session.getMapper(CompraMapper.class);
	        compraMapper.actualizarStockPorCompra(ingreso.getIdCompra());

	        session.commit();
	    } catch (Exception e) {
	        System.out.println("❌ Error al registrar ingreso: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


}
