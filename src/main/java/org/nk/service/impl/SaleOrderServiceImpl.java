package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.SaleOrder;
import org.nk.repo.SaleOrderRepository;
import org.nk.service.ISaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService {

	@Autowired
	private SaleOrderRepository repo;

	@Transactional
	@Override
	public Integer saveSale(SaleOrder so) {
		return repo.save(so).getSorder_Id();
	}

	@Transactional
	@Override
	public void deleteSale(Integer id) {
		repo.deleteById(id);
	}

	@Transactional
	@Override
	public void updateSale(SaleOrder so) {
		repo.save(so);
	}

	@Transactional
	@Override
	public Optional<SaleOrder> getOneSale(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public List<SaleOrder> getAllSale() {
		return repo.findAll();
	}

}

