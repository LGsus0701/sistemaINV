package services;

import java.util.List;

import models.Ingreso;



public interface IngresoService {

	List<Ingreso> listarIngresos();
	void insertarIngreso(Ingreso ingreso);

}
