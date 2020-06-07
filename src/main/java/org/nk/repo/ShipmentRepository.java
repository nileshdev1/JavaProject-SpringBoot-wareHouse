package org.nk.repo;

import org.nk.model.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<ShipmentType, Integer> {

}
