package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.WhUserType;
import org.nk.repo.WhUserTypeRepository;
import org.nk.service.IWhUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private WhUserTypeRepository repo;
	
	@Override
	public Integer saveWhUserType(WhUserType whuser) {
		return repo.save(whuser).getUser_Type_Id();
	}

	@Override
	public void updateWhUserType(WhUserType whuser) {
		repo.save(whuser);
	}
	
	@Override
	public void deleteWhUserType(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public List<WhUserType> getAllWhUserType() {
		List<WhUserType> list=repo.findAll();
		return list;
	}
	
	@Override
	public Optional<WhUserType> getOneWhUserType(Integer id) {
		Optional<WhUserType> whuser=repo.findById(id);
		return whuser;
	}
	
	
	
	
}
