package services.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.IngresoMapper;
import models.Ingreso;
import services.IngresoService;


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

}
