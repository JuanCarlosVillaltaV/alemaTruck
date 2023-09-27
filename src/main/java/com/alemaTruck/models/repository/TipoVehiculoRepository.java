package com.alemaTruck.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alemaTruck.models.entity.TipoVehiculos;

@Repository
public interface TipoVehiculoRepository extends CrudRepository<TipoVehiculos, Integer> {

}
