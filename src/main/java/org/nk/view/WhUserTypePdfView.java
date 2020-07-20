package org.nk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nk.model.WhUserType;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

response.addHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");
		
		Paragraph p=new Paragraph("WELCOME TO WHUSER TYPE");
		
		document.add(p);
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("obj");
		
		PdfPTable t=new PdfPTable(6);
		
		t.addCell("ID");
		t.addCell("USER TYPE");
		t.addCell("USER CODE");
		t.addCell("USER FOR");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("ID TYPE");
		t.addCell("OTHER ID");
		t.addCell("ID NUMBER");
		
		for(WhUserType wh:list) {
			
			t.addCell(wh.getUser_Type_Id().toString());
			t.addCell(wh.getUser_type());
			t.addCell(wh.getUser_Code());
			t.addCell(wh.getUser_For());
			t.addCell(wh.getUser_Email());			
			t.addCell(wh.getUser_Contact());
			t.addCell(wh.getUser_id_type());
			t.addCell(wh.getOther_id());
			t.addCell(wh.getId_Number());
		}
		
		document.add(t);
		
		document.add(new Paragraph(new Date().toString()));
	}
}
