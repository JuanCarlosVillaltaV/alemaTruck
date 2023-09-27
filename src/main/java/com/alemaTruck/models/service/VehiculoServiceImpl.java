package com.alemaTruck.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemaTruck.models.entity.Vehiculos;
import com.alemaTruck.models.repository.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public List<Vehiculos> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Vehiculos>)vehiculoRepository.findAll() ;
		
	}

	@Override
	public void guardar(Vehiculos vehiculos) {
		// TODO Auto-generated method stub
		vehiculoRepository.save(vehiculos);

	}

	@Override
	public Vehiculos buscarPorId(Integer idvehiculo) {
		// TODO Auto-generated method stub
		return vehiculoRepository.findById(idvehiculo).orElse(null);
	}

	@Override
	public void eliminar(Integer idvehiculo) {
		// TODO Auto-generated method stub
		vehiculoRepository.deleteById(idvehiculo);

	}

}
