package services.impl;

import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import config.MyBatisUtil;
import dao.ProveedorMapper;
import models.Proveedor;
import services.ProveedorService;


public class ProveedorServiceImpl implements ProveedorService {
	
	@Override
	public List<Proveedor> listarProveedores() {
	    try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
	        ProveedorMapper proveedorMapper = session.getMapper(ProveedorMapper.class);
	        List<Proveedor> proveedores = proveedorMapper.listarProveedores();

	        System.out.println("📌 proveedores obtenidos: " + proveedores.size());
	        for (Proveedor p : proveedores) {
	            System.out.println("➡ " + p.getIdProveedor() + " - " + p.getNombreComercial());
	        }

	        return proveedores; // ← ESTA LÍNEA ES NECESARIA
	    } catch (Exception e) {
	        System.out.println("❌ Error en listarProveedores: " + e.getMessage());
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}

	

}
