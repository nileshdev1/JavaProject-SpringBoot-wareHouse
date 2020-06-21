package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.OrderMethod;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.xlsx");

		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>)model.get("obj");

		Sheet sheet=workbook.createSheet("OrderMethod");

		setHead(sheet);
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ORDER METHOD");
		row.createCell(4).setCellValue("ORDER ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");

	}

	private void setBody(Sheet sheet, List<OrderMethod> list) {
		
		int rowNum=1;
		
		for(OrderMethod om:list) {
			Row row=sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(om.getOrder_Method_Id());
			row.createCell(1).setCellValue(om.getOrder_Mode());
			row.createCell(2).setCellValue(om.getOrder_Code());
			row.createCell(3).setCellValue(om.getOrder_Method());
			row.createCell(4).setCellValue(om.getOrder_Accept().toString());
			row.createCell(5).setCellValue(om.getDescription());
		}

	}

}
