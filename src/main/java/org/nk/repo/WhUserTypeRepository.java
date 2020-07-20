package org.nk.repo;

import java.util.List;

import org.nk.model.WhUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WhUserTypeRepository extends JpaRepository<WhUserType, Integer> {
	
	@Query(" select wh.user_type,count(wh.user_type) from WhUserType wh GROUP BY wh.user_type ")
	public List<Object[]> getWhUserCount();

}
