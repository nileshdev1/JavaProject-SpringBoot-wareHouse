package org.nk.controller;

import java.util.List;
import java.util.Optional;

import org.nk.model.SaleOrder;
import org.nk.service.ISaleOrderService;
import org.nk.service.IShipmentTypeService;
import org.nk.service.IWhUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sorder")
public class SaleOrderController {

	@Autowired
	private ISaleOrderService service;
	
	@Autowired
	private IShipmentTypeService shipmentService;
	
	@Autowired
	private IWhUserTypeService whservice;
	
	public void addDropDownUi(Model model) {
		model.addAttribute("shipmentTypes", shipmentService.getShipmentIdAndCode());
		model.addAttribute("whUserTypes", whservice.getWhUserTypeIdAndCode("customer"));
	}

	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("sorder", new SaleOrder());
		addDropDownUi(model);
		System.out.println(whservice.getWhUserTypeIdAndCode("customer"));
		System.out.println(shipmentService.getShipmentIdAndCode());
		return "SaleOrderRegister";
	}
	
	@PostMapping("/save")
	public String saveSaleOrder(@ModelAttribute SaleOrder sorder, Model model) {
		Integer id=service.saveSale(sorder);
		String msg="SaleOrder "+id+" Created";
		model.addAttribute("msg", msg);
		model.addAttribute("sorder", new SaleOrder());
		addDropDownUi(model);
		return "SaleOrderRegister";
		
	}
	
	@GetMapping("/all")
	public String getAllSaleOrder(Model model) {
		List<SaleOrder> order=service.getAllSale();
		model.addAttribute("list", order);
		return "SaleOrderData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSaleOrder(@PathVariable Integer id, Model model) {
		service.deleteSale(id);
		String msg="Order Id "+id+" Deleted";
		model.addAttribute("msg", msg);
		List<SaleOrder> order=service.getAllSale();
		model.addAttribute("list", order);
		return "SaleOrderData";
	}
	
	@GetMapping("/edit/{id}")
	public String editSaleOrder(@PathVariable Integer id,Model model) {
		Optional<SaleOrder> opt=service.getOneSale(id);
		SaleOrder sorder=opt.get();
		model.addAttribute("sorder", sorder);
		addDropDownUi(model);
		return "SaleOrderEdit";
	}
	
	@PostMapping("/update")
	public String updateSaleOrder(@ModelAttribute SaleOrder sorder, Model model) {
		service.saveSale(sorder);
		List<SaleOrder> order=service.getAllSale();
		model.addAttribute("list", order);
		return "SaleOrderData";
	}
	
	@GetMapping("/view/{id}")
	public String viewSaleOrder(@PathVariable Integer id,Model model) {
		Optional<SaleOrder> opt=service.getOneSale(id);
		SaleOrder order=opt.get();
		model.addAttribute("sorder", order);
		return "SaleOrderView";
	}
}
