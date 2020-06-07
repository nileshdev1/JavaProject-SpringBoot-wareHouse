package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.ShipmentType;
import org.nk.repo.ShipmentRepository;
import org.nk.service.IShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentRepository repo;
	
	@Override
	public Integer saveShipment(ShipmentType ship) {
		
		return repo.save(ship).getShip_id();		
	}

	@Override
	public void deleteShipment(Integer id) {

		repo.deleteById(id);
	}

	@Override
	public void updateShipment(ShipmentType ship) {

		repo.save(ship);
	}

	@Override
	public ShipmentType getOneShipment(Integer id) {

		return repo.findById(id).get();
	}

	@Override
	public List<ShipmentType> getAllShipment() {

		return repo.findAll();
	}

}
