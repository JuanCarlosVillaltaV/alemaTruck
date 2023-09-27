package com.alemaTruck.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alemaTruck.models.entity.Vehiculos;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculos, Integer> {

}
