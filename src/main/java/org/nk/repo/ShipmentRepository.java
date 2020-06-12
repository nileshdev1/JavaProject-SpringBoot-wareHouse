package org.nk.repo;

import org.nk.model.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 * @Interface:  Repository
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */

public interface ShipmentRepository extends JpaRepository<ShipmentType, Integer> {

}
