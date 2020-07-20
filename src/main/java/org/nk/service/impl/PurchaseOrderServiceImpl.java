package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.PurchaseOrder;
import org.nk.repo.PurchaseOrderRepository;
import org.nk.service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repo;
	
	@Transactional
	@Override
	public Integer savePurchase(PurchaseOrder po) {
		return repo.save(po).getPorder_Id();
	}

	@Transactional
	@Override
	public void deletePurchase(Integer id) {
		repo.deleteById(id);
	}

	@Transactional
	@Override
	public void updatePurchase(PurchaseOrder po) {
		repo.save(po);
	}

	@Transactional
	@Override
	public Optional<PurchaseOrder> getOnePurchase(Integer id) {
		return repo.findById(id);
	}

	@Transactional
	@Override
	public List<PurchaseOrder> getAllPurchase() {
		return repo.findAll();
	}

}
