package org.nk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nk.model.Uom;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

response.addHeader("Content-Disposition", "attachment;filename=Uom.pdf");
		
		Paragraph p=new Paragraph("WELCOME TO UOM");
		
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>)model.get("obj");
		
		PdfPTable t=new PdfPTable(6);
		
		t.addCell("ID");
		t.addCell("UOM TYPE");
		t.addCell("UOM MODEL");
		t.addCell("NOTE");
		
		for(Uom um:list) {
			
			t.addCell(um.getUom_Id().toString());
			t.addCell(um.getUom_Type());
			t.addCell(um.getUom_Model());
			t.addCell(um.getDescription());
		}
		
		document.add(t);
		
		document.add(new Paragraph(new Date().toString()));
	}
}
