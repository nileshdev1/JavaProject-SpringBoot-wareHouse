package org.nk.controller;

import java.util.List;
import java.util.Optional;

import org.nk.model.PurchaseOrder;
import org.nk.service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/porder")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("porder", new PurchaseOrder());
		return "PurchaseOrderRegister";
	}
	
	@PostMapping("/save")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder porder, Model model) {
		Integer id=service.savePurchase(porder);
		String msg="PurchaseOrder "+id+" Created";
		model.addAttribute("msg", msg);
		model.addAttribute("porder", new PurchaseOrder());
		return "PurchaseOrderRegister";
		
	}
	
	@GetMapping("/all")
	public String getAllPurchaseOrder(Model model) {
		List<PurchaseOrder> list=service.getAllPurchase();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deletePurchaseOrder(@PathVariable Integer id, Model model) {
		service.deletePurchase(id);
		String msg="Order Id "+id+" Deleted";
		model.addAttribute("msg", msg);
		List<PurchaseOrder> list=service.getAllPurchase();
		model.addAttribute("list", list);	
		return "PurchaseOrderData";
	}
	
	@GetMapping("/edit/{id}")
	public String editPurchaseOrder(@PathVariable Integer id, Model model) {
		Optional<PurchaseOrder> opt=service.getOnePurchase(id);
		PurchaseOrder order=opt.get();
		model.addAttribute("porder", order);
		return "PurchaseOrderEdit";
	}
	
	@PostMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder porder, Model model) {
		service.savePurchase(porder);
		List<PurchaseOrder> list=service.getAllPurchase();
		model.addAttribute("list", list);	
		return "PurchaseOrderData";
	}
	
	@GetMapping("/view/{id}")
	public String viewPurchaseOrder(@PathVariable Integer id, Model model) {
		Optional<PurchaseOrder> opt=service.getOnePurchase(id);
		PurchaseOrder order=opt.get();
		model.addAttribute("porder", order);
		return "PurchaseOrderView";
	}
	
}
