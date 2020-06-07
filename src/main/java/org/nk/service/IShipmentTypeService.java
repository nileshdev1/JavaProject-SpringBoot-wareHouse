package org.nk.service;

import java.util.List;

import org.nk.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipment(ShipmentType ship);
	public void deleteShipment(Integer id);
	public void updateShipment(ShipmentType ship);
	public ShipmentType getOneShipment(Integer id);
	public List<ShipmentType> getAllShipment();
}
