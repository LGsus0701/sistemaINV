package dao;

import java.util.List;

import models.Ingreso;

public interface IngresoMapper {
	List<Ingreso> listarIngresos();
	void insertarIngreso(Ingreso ingreso);

}
