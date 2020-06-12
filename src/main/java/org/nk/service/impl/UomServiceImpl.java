package org.nk.service.impl;


import java.util.List;
import java.util.Optional;
import org.nk.model.Uom;
import org.nk.repo.UomRepository;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Integer saveUom(Uom uom) {
		return repo.save(uom).getUom_Id();
	}

	
	@Override
	public List<Uom> getAllUom() {
		List<Uom> list=repo.findAll();
		return list;
	}
	
	
	
	@Override
	public void deleteUom(Integer id) {
		repo.deleteById(id);
	}

	
	@Override
	public void updateUom(Uom uom) {
		repo.save(uom);
	}

	
	@Override
	public Optional<Uom> getOneUom(Integer id) {
		Optional<Uom> uom=repo.findById(id);
		return uom;
	}

}
