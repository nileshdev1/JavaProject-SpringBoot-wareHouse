package org.nk.controller;

import java.util.List;

import org.nk.model.Uom;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service; 
	
	@GetMapping("/register")
	public String shorRegister() {
		
		return "UomRegister";
	}
	
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		
		Integer id=service.saveUom(uom);
		String message="Uom "+id+" is created";
		model.addAttribute("msg", message);
		
		return "UomRegister";
	}
	
	@GetMapping("/all")
	public String getAllUom(Model model) {
		
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
		
		return "UomData";
	}
}
