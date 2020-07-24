package org.nk.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.nk.model.ShipmentType;
import org.nk.repo.ShipmentRepository;
import org.nk.service.IShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * @Class:  ServiceImpl
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */


@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private ShipmentRepository repo;



	@Override
	@Transactional
	public Integer saveShipment(ShipmentType ship) {	
		return repo.save(ship).getShip_id();		
	}


	@Override
	@Transactional
	public void deleteShipment(Integer id) {
		repo.deleteById(id);
	}


	@Override
	@Transactional
	public void updateShipment(ShipmentType ship) {
		repo.save(ship);
	}


	@Override
	@Transactional
	public Optional<ShipmentType> getOneShipment(Integer id) {
		Optional<ShipmentType> opt=repo.findById(id);
		return opt;
	}


	@Override
	@Transactional
	public List<ShipmentType> getAllShipment() {
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public List<Object[]> getShipmentCount() {

		return repo.getShipmentCount();
	}
	
	@Override
	public Map<Integer, String> getShipmentIdAndCode() {

		return repo.getShipmentIdAndCode().stream()
				.collect(Collectors.toMap(
						ob->Integer.valueOf(ob[0].toString()), 
						ob->ob[1].toString()
						)
						);
	}

}
