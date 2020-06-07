package org.nk.controller;

import java.util.List;

import org.nk.model.ShipmentType;
import org.nk.service.IShipmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/register")
	public String showRegister() {
		
		return "ShipmentRegister";
	}
	
	@PostMapping("/save")
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {
		
		Integer id=service.saveShipment(shipmentType);
		String message="Shipment id "+id+" created";
		
		model.addAttribute("msg", message);
		
		return "ShipmentRegister";
	}
	
	@GetMapping("/all")
	public String getAllShipment(Model model) {
		
		List<ShipmentType> list=service.getAllShipment();
		model.addAttribute("list", list);
		
		return "ShipmentData";
	}
	
	
	
	
}
