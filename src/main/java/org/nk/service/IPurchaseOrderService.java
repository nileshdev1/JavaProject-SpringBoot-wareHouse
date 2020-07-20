package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer savePurchase(PurchaseOrder po);
	public void deletePurchase(Integer id);
	public void updatePurchase(PurchaseOrder po);
	public Optional<PurchaseOrder> getOnePurchase(Integer id);
	public List<PurchaseOrder> getAllPurchase();
}
