package com.alemaTruck.models.service;

import java.util.List;

import com.alemaTruck.models.entity.Vehiculos;

public interface IVehiculoService {
	
	public List<Vehiculos> listarTodos();
	public void guardar(Vehiculos vehiculos);
	public Vehiculos buscarPorId(Integer idvehiculo);
	public void eliminar(Integer idvehiculo);

}
