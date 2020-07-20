package org.nk.repo;

import java.util.List;

import org.nk.model.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*
 * @Interface:  Repository
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */

public interface ShipmentRepository extends JpaRepository<ShipmentType, Integer> {

	@Query(" select st.shipment_Mode,count(st.shipment_Mode) from ShipmentType st GROUP BY st.shipment_Mode ")
	public List<Object[]> getShipmentCount();
	
}
