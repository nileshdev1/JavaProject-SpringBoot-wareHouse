package org.nk.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.nk.model.Document;
import org.nk.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	@GetMapping("/upload")
	public String showDocument(Model model) {
		model.addAttribute("document", new Document());
		return "DocumentUpload";
	}
	
	
	@GetMapping("/all")
	public String showDocs(Model model) {
		model.addAttribute("list", service.findIdAndName());
		return "DocumentAll";
	}
	
	@PostMapping("/save")
	public String upload(@RequestParam Integer fileId, @RequestParam MultipartFile fileOb, Model model) {
		
		if(fileOb!=null && fileId!=null) {
			Document doc=new Document();
			doc.setDocId(fileId);
			doc.setDocName(fileOb.getOriginalFilename());
			
			try {
				doc.setDocData(fileOb.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			service.saveDocument(doc);
			String message="File Uploaded Sucessfully";
			model.addAttribute("msg", message);
			model.addAttribute("document", new Document());
		}
		
		return "DocumentUpload";
	}
	
	@GetMapping("/download/{id}")
	public void downloadDoc(@PathVariable Integer id,HttpServletResponse resp) {
		Optional<Document> opt=service.findDocument(id);
		
		if(opt.isPresent()) {
			Document doc=opt.get();
			
			resp.addHeader("Content:Disposition", "attachment;filename=" + doc.getDocName());
			
			try {
				FileCopyUtils.copy(doc.getDocData(),resp.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
