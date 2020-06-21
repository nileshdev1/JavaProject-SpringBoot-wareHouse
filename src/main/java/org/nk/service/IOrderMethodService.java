package org.nk.service;

import java.util.List;
import java.util.Optional;
import org.nk.model.OrderMethod;


public interface IOrderMethodService {

	public Integer saveOrderMethod(OrderMethod order);
	public void deleteOrderMethod(Integer id);
	public void updateOrderMethod(OrderMethod order);
	public Optional<OrderMethod> getOneOrderMethod(Integer id);
	public List<OrderMethod> getAllOrderMethod();
}
