package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.SaleOrder;

public interface ISaleOrderService {

	public Integer saveSale(SaleOrder so);
	public void deleteSale(Integer id);
	public void updateSale(SaleOrder so);
	public Optional<SaleOrder> getOneSale(Integer id);
	public List<SaleOrder> getAllSale();
}
