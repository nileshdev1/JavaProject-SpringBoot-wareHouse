package org.nk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.nk.model.OrderMethod;
import org.nk.service.IOrderMethodService;
import org.nk.util.OrderMethodUtil;
import org.nk.view.OrderMethodExcelView;
import org.nk.view.OrderMethodPdfView;
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
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@Autowired
	private OrderMethodUtil util;
	
	@Autowired
	private ServletContext context;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("order", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@PostMapping("/save")
	public String saveOrderMethod(@ModelAttribute OrderMethod order, Model model) {
		Integer id=service.saveOrderMethod(order);
		String message="OrderMethod "+id+ " Created";
		model.addAttribute("msg", message);
		model.addAttribute("order", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	@GetMapping("/all")
	public String getAllOrderMethod(Model model) {
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOrderMethod(@PathVariable Integer id, Model model) {
		service.deleteOrderMethod(id);
		String message="OrderMethod "+id+" Deleted";
		model.addAttribute("msg", message);
		
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditPage(@PathVariable Integer id, Model model) {
		Optional<OrderMethod>opt=service.getOneOrderMethod(id);
		OrderMethod order=opt.get();
		model.addAttribute("order", order);
		return "OrderMethodEdit";
	}
	
	@PostMapping("/update")
	public String updateOrderMethod(@ModelAttribute OrderMethod order, Model model) {
		service.saveOrderMethod(order);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}
	
	@GetMapping("/view/{id}")
	public String viewOrderMethod(@PathVariable Integer id, Model model) {
		Optional<OrderMethod> opt=service.getOneOrderMethod(id);
		OrderMethod order=opt.get();
		model.addAttribute("order", order);
		return "OrderMethodView";
	}
	
	@GetMapping("/excel")
	public ModelAndView exportExcelOrderMethod() {
		ModelAndView mav=new ModelAndView();
		mav.setView(new OrderMethodExcelView());
		
		List<OrderMethod> list=service.getAllOrderMethod();
		mav.addObject("obj",list);
		return mav;
		
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelOrderMethodOne(@PathVariable Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new OrderMethodExcelView());
		
		Optional<OrderMethod> opt=service.getOneOrderMethod(id);
		if(opt.isPresent()) {
			mav.addObject("obj",Arrays.asList(opt.get()));
		}
		return mav;
	}
	
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView mav=new ModelAndView();
		mav.setView(new OrderMethodPdfView());
		List<OrderMethod> list=service.getAllOrderMethod();
		mav.addObject("obj",list);
		
		return mav;
	}
	
	@GetMapping("/pdf/{id}")
	public ModelAndView exportPdfOne(@PathVariable Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new OrderMethodPdfView());
		
		Optional<OrderMethod> opt=service.getOneOrderMethod(id);
		if(opt.isPresent()) {
			mav.addObject("obj", Arrays.asList(opt.get()));
		}
		return mav;
	}
	
	@GetMapping("/charts")
	public String generateCharts() {
		List<Object[]> list=service.getOrderMethodCount();
		
		String location=context.getRealPath("/");
		util.generatePie(location, list);
		util.generateBar(location, list);
		
		return "OrderMethodCharts";
	}
}
