package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.ShipmentType;

/*
 * @Interface:  Service
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */

public interface IShipmentTypeService {

	public Integer saveShipment(ShipmentType ship);
	public void deleteShipment(Integer id);
	public void updateShipment(ShipmentType ship);
	public Optional<ShipmentType> getOneShipment(Integer id);
	public List<ShipmentType> getAllShipment();
}
