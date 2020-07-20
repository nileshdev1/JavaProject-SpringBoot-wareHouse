package org.nk.repo;

import java.util.List;

import org.nk.model.Uom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * @Interface:  Repository
 * @Author:  Nil
 * @Version: 1.0
 * @UOM
 */

public interface UomRepository extends JpaRepository<Uom, Integer> {

	@Query(" select um.uom_Type,count(um.uom_Type) from Uom um GROUP BY um.uom_Type ")
	public List<Object[]> getUomCount();
	
	@Query(" select uom_Id, uom_Model from Uom ")
	public List<Object[]> getUomIdandModel();
}
