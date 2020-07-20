package org.nk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.nk.model.WhUserType;
import org.nk.service.IWhUserTypeService;
import org.nk.util.WhUserTypeUtil;
import org.nk.view.WhUserTypeExcelView;
import org.nk.view.WhUserTypePdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeUtil util;
	@Autowired
	private ServletContext context;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("whuser", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	@PostMapping("/save")
	public String saveWhUserType(@ModelAttribute WhUserType whuser, Model model) {
		Integer id=service.saveWhUserType(whuser);
		String message="WhUserType "+id+" Created";
		model.addAttribute("whuser", new WhUserType());
		model.addAttribute("msg", message);
		return "WhUserTypeRegister";
	}
	
	@GetMapping("/all")
	public String getAllWhUserType(Model model) {
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteWhUserType(@PathVariable Integer id, Model model) {
		service.deleteWhUserType(id);
		String message="WhUser "+id+" Deleted";
		model.addAttribute("msg", message);
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	
	@GetMapping("/edit/{id}")
	public String editWhUserType(@PathVariable Integer id,Model model) {
		Optional<WhUserType> opt=service.getOneWhUserType(id);
		WhUserType whuser=opt.get();
		model.addAttribute("whuser", whuser);
		
		return "WhUserTypeEdit";
	}
	
	@PostMapping("/update")
	public String updateWhUserType(@ModelAttribute WhUserType whuser, Model model) {
		service.saveWhUserType(whuser);
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
		
	}
	
	@GetMapping("/view/{id}")
	public String viewWhUserType(@PathVariable Integer id, Model model) {
		Optional<WhUserType> opt=service.getOneWhUserType(id);
		WhUserType whuser=opt.get();
		model.addAttribute("whuser", whuser);
		return "WhUserTypeView";
	}
	
	@GetMapping("/excel")
	public ModelAndView exportExcelWhUserType() {
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypeExcelView());
		
		List<WhUserType> list=service.getAllWhUserType();
		mav.addObject("obj", list);
		return mav;
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelWhUserTypeOne(@PathVariable Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypeExcelView());
		
		Optional<WhUserType> opt=service.getOneWhUserType(id);
		if(opt.isPresent()) {
			mav.addObject("obj", Arrays.asList(opt.get()));
		}
		return mav;
	}
	
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypePdfView());
		List<WhUserType> list=service.getAllWhUserType();
		mav.addObject("obj",list);
		
		return mav;
	}
	
	@GetMapping("/pdf/{id}")
	public ModelAndView exportPdfOne(@PathVariable Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypePdfView());
		
		Optional<WhUserType> opt=service.getOneWhUserType(id);
		if(opt.isPresent()) {
			mav.addObject("obj", Arrays.asList(opt.get()));
		}
		return mav;
	}
	
	@GetMapping("/charts")
	public String generateCharts() {
		List<Object[]> list=service.getWhUserCount();
		
		String location=context.getRealPath("/");
		util.generatePie(location, list);
		util.generateBar(location, list);
		
		return "WhUserTypeCharts";
	}
}
