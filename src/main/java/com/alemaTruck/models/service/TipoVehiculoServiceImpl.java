package com.alemaTruck.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alemaTruck.models.entity.TipoVehiculos;
import com.alemaTruck.models.repository.TipoVehiculoRepository;


@Service
public class TipoVehiculoServiceImpl implements ITipoVehiculoService {
	
	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	@Override
	public List<TipoVehiculos> listaTipoVehiculos() {
		// TODO Auto-generated method stub
		return (List<TipoVehiculos>) tipoVehiculoRepository.findAll();
		
	}

	@Override
	public List<TipoVehiculos> listarTodos() {
		// TODO Auto-generated method stub
		return (List<TipoVehiculos>) tipoVehiculoRepository.findAll();
	}

	@Override
	public void guardar(TipoVehiculos tipovehiculos) {
		// TODO Auto-generated method stub
        tipoVehiculoRepository.save(tipovehiculos);
	}

	@Override
	public TipoVehiculos buscarPorId(Integer idtipovehiculos) {
		// TODO Auto-generated method stub
		return tipoVehiculoRepository.findById(idtipovehiculos).orElse(null);
	}

	@Override
	public void eliminar(Integer idtipovehiculos) {
		// TODO Auto-generated method stub
      tipoVehiculoRepository.deleteById(idtipovehiculos);
	}

}
