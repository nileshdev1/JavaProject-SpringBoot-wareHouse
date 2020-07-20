package org.nk.controller;

import java.util.List;
import java.util.Optional;

import org.nk.model.Part;
import org.nk.service.IPartService;
import org.nk.service.IUomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;
	
	@Autowired
	private IUomService uservice;
	
	
	public void addDropDownUi(Model model) {
		model.addAttribute("uom", uservice.getUomIdandModel());
	}
	
	@GetMapping("/register")
	public String shoeRegisterPage(Model model) {
		model.addAttribute("part", new Part());
		addDropDownUi(model);
		return "PartRegister";
	}
	
	@PostMapping("/save")
	public String savePart(@ModelAttribute Part part, Model model) {
		Integer id=service.savePart(part);
		String message="Part "+id+" Created";
		model.addAttribute("msg", message);
		model.addAttribute("part", new Part());
		addDropDownUi(model);
		return "PartRegister";
	}
	
	@GetMapping("/all")
	public String getAllPart(Model model) {
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
		
		return "PartData";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePart(@PathVariable Integer id,Model model) {
		service.deletePart(id);
		String message="Part "+id+ " Deleted";
		model.addAttribute("msg", message);
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
		
		return "PartData";
	}
	
	@GetMapping("/edit/{id}")
	public String editPart(@PathVariable Integer id, Model model) {
		Optional<Part> opt=service.getOnePart(id);
		Part part=opt.get();
		model.addAttribute("part", part);
		addDropDownUi(model);
		return "PartEdit";
	}
	
	@PostMapping("/update")
	public String updatePart(@ModelAttribute Part part, Model model) {
		service.savePart(part);
		List<Part> list=service.getAllPart();
		model.addAttribute("list", list);
		addDropDownUi(model);
		return "PartData";
	}
	
	@GetMapping("/view/{id}")
	public String viewPart(@PathVariable Integer id, Model model) {
		Optional<Part> opt=service.getOnePart(id);
		Part part=opt.get();
		model.addAttribute("part", part);
		
		return "PartView";
	}
	
}
