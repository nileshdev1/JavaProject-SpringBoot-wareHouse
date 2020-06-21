package org.nk.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.nk.model.Uom;
import org.nk.service.IUomService;
import org.nk.view.UomExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Class:  Controller
 * @Author:  Nil
 * @Version: 1.0
 * @UOM
 */


@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service; 
	
	/*
	 * Find the RegistrationForm to Generate UOM
	 */
	@GetMapping("/register")
	public String shorRegister(Model model) {
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	
	/*
	 * Take Data from form and save into DB
	 */
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		Integer id=service.saveUom(uom);
		String message="Uom "+id+" is created";
		model.addAttribute("msg", message);
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	
	/*
	 * Find the All UOM Data
	 */
	@GetMapping("/all")
	public String getAllUom(Model model) {
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
		return "UomData";
	}
	
	/*
	 * Remove the one selected UOM
	 * And Return back to All Data Page
	 */
	@GetMapping("/delete/{id}")
	public String deleteUom(@PathVariable Integer id, Model model) {
		service.deleteUom(id);
		String message="UOM "+ id + "Deleted";
		model.addAttribute("msg", message);
		
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
		return "UomData";
	}
	
	/*
	 * View All Data to selected ID
	 */
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id,Model model) {
		Optional<Uom>opt=service.getOneUom(id);
		Uom uom=opt.get();
		model.addAttribute("uom", uom);
		return "UomEdit";
	}
	
	/*
	 * Modify UOM Data 
	 */
	@PostMapping("/update")
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.saveUom(uom);
		List<Uom> list=service.getAllUom();
		model.addAttribute("list",list);
		return "UomData";
	}
	
	@GetMapping("/excel")
	public ModelAndView exportExcelUom() {
		
		ModelAndView mav=new ModelAndView();
		mav.setView(new UomExcelView());
		
		List<Uom> uom=service.getAllUom();
		mav.addObject("obj", uom);
		return mav;
	}
	
	@GetMapping("/excel/{id}")
	public ModelAndView exportExcelUomOne(@PathVariable Integer id) {
		ModelAndView mav=new ModelAndView();
		mav.setView(new UomExcelView());
		
		Optional<Uom> opt=service.getOneUom(id);
		if(opt.isPresent()) {
			mav.addObject("obj",Arrays.asList(opt.get()));
		}
		return mav;	
	}
}
