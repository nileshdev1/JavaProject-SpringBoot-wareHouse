package org.nk.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nk.model.OrderMethod;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");

		Paragraph p=new Paragraph("WELCOME TO ORDER METHOD");

		document.add(p);

		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("obj");

		PdfPTable t=new PdfPTable(6);

		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ORDER METHOD");
		t.addCell("ORDER ACCEPT");
		t.addCell("NOTE");

		for(OrderMethod om:list) {

			t.addCell(om.getOrder_Method_Id().toString());
			t.addCell(om.getOrder_Mode());
			t.addCell(om.getOrder_Code());
			t.addCell(om.getOrder_Method());
			t.addCell(om.getOrder_Accept().toString());
			t.addCell(om.getDescription());
		}

		document.add(t);

		document.add(new Paragraph(new Date().toString()));
	}
}
