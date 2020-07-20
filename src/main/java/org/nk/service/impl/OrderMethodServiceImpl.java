package org.nk.service.impl;

import java.util.List;
import java.util.Optional;

import org.nk.model.OrderMethod;
import org.nk.repo.OrderMethodRepository;
import org.nk.service.IOrderMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private OrderMethodRepository repo;
	
	
	@Override
	public Integer saveOrderMethod(OrderMethod order) {
		return repo.save(order).getOrder_Method_Id();
	}

	
	@Override
	public void deleteOrderMethod(Integer id) {
		repo.deleteById(id);
	}

	
	@Override
	public void updateOrderMethod(OrderMethod order) {
		repo.save(order);
	}

	
	@Override
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
		return repo.findById(id);
	}

	
	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list=repo.findAll();
		return list;
	}
	
	@Override
	public List<Object[]> getOrderMethodCount() {
		return repo.getOrderMethodCount();
	}

}
