package org.nk.service.impl;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.nk.model.Uom;
import org.nk.repo.UomRepository;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * @Class:  ServiceImpl
 * @Author:  Nil
 * @Version: 1.0
 * @UOM
 */

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private UomRepository repo;

	
		
	@Override
	@Transactional
	public Integer saveUom(Uom uom) {
		return repo.save(uom).getUom_Id();
	}

	
	@Override
	@Transactional
	public List<Uom> getAllUom() {
		List<Uom> list=repo.findAll();
		return list;
	}
	
	
	
	@Override
	@Transactional
	public void deleteUom(Integer id) {
		repo.deleteById(id);
	}

	
	@Override
	@Transactional
	public void updateUom(Uom uom) {
		repo.save(uom);
	}

	
	@Override
	@Transactional
	public Optional<Uom> getOneUom(Integer id) {
		Optional<Uom> uom=repo.findById(id);
		return uom;
	}

	@Override
	@Transactional
	public List<Object[]> getUomCount() {
		return repo.getUomCount();
	}
	

	@Override
	@Transactional(readOnly= true)
	public Map<Integer, String> getUomIdandModel() {
		Map<Integer, String> map=new LinkedHashMap<>();
		List<Object[]> list=repo.getUomIdandModel();
		for(Object[] ob: list) {
			map.put(Integer.valueOf(ob[0].toString()), ob[1].toString());
		}	
		return map;
	}
}
