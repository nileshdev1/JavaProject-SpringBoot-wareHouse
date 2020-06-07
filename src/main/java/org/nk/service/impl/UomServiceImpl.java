package org.nk.service.impl;

import java.util.List;

import org.nk.model.Uom;
import org.nk.repo.UomRepository;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private UomRepository repo;
	
	@Override
	public Integer saveUom(Uom uom) {

		return repo.save(uom).getUom_Id();
	}

	@Override
	public List<Uom> getAllUom() {

		List<Uom> list=repo.findAll();
		return list;
	}

}
