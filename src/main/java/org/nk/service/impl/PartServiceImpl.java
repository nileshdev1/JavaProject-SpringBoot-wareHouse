package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.Part;
import org.nk.repo.PartRepository;
import org.nk.service.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartServiceImpl implements IPartService {

	@Autowired
	private PartRepository repo;
	
	@Override
	@Transactional
	public Integer savePart(Part prt) {
		return repo.save(prt).getPart_Id();
	}

	@Override
	@Transactional
	public void deletePart(Integer id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional
	public void updatePart(Part prt) {
		repo.save(prt);
	}

	@Override
	@Transactional
	public Optional<Part> getOnePart(Integer id) {
		return repo.findById(id);
	}

	@Override
	@Transactional
	public List<Part> getAllPart() {
		List<Part> list=repo.findAll();
		return list;
	}

}
