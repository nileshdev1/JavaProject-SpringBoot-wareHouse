package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.WhUserType;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=WhUserType.xlsx");

		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>)model.get("obj");

		Sheet sheet=workbook.createSheet("WhUserType");

		setHead(sheet);
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("USER TYPE");
		row.createCell(2).setCellValue("USER CODE");
		row.createCell(3).setCellValue("USER FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT NO");
		row.createCell(6).setCellValue("ID TYPE");
		row.createCell(7).setCellValue("OTHER ID TYPE");
		row.createCell(8).setCellValue("ID NUMBER");

	}

	private void setBody(Sheet sheet, List<WhUserType> list) {
		
		int rowNum=1;
		
		for(WhUserType wh:list) {
			Row row=sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(wh.getUser_Type_Id());
			row.createCell(1).setCellValue(wh.getUser_type());
			row.createCell(2).setCellValue(wh.getUser_Code());
			row.createCell(3).setCellValue(wh.getUser_For());
			row.createCell(4).setCellValue(wh.getUser_Email());
			row.createCell(5).setCellValue(wh.getUser_Contact());
			row.createCell(6).setCellValue(wh.getUser_id_type());
			row.createCell(7).setCellValue(wh.getOther_id());
			row.createCell(8).setCellValue(wh.getId_Number());
		}

	}

}
