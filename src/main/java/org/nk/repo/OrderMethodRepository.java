package org.nk.repo;

import java.util.List;

import org.nk.model.OrderMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

	@Query(" select om.order_Mode,count(om.order_Mode) from OrderMethod om GROUP BY om.order_Mode ")
	public List<Object[]> getOrderMethodCount();
}
