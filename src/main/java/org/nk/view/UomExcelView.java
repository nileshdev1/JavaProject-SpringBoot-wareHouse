package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.Uom;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		response.addHeader("Content-Disposition", "attachment;filename=UOM.xlsx");
		
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>)model.get("obj");
		
		Sheet sheet=workbook.createSheet("UOM");
		
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("UOM TYPE");
		row.createCell(2).setCellValue("UOM MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
	}

	private void setBody(Sheet sheet, List<Uom> list) {

		int rowNum=1;
		
		for(Uom uom:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getUom_Id());
			row.createCell(1).setCellValue(uom.getUom_Type());
			row.createCell(2).setCellValue(uom.getUom_Model());
			row.createCell(3).setCellValue(uom.getDescription());
			
		}
	}

}
