package com.alemaTruck.models.service;

import java.util.List;

import com.alemaTruck.models.entity.TipoVehiculos;

public interface ITipoVehiculoService {

	List<TipoVehiculos> listaTipoVehiculos();
	
	public List<TipoVehiculos> listarTodos();
	public void guardar(TipoVehiculos tipovehiculos);
	public TipoVehiculos buscarPorId(Integer idtipovehiculos);
	public void eliminar(Integer idtipovehiculos);
}
