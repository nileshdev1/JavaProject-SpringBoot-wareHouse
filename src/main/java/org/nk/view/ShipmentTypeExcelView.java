package org.nk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.nk.model.ShipmentType;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=ShipmentType.xlsx");

		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>)model.get("obj");

		Sheet sheet=workbook.createSheet("SHIPMENT TYPES");

		setHead(sheet);
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");

	}

	private void setBody(Sheet sheet, List<ShipmentType> list) {
		
		int rowNum=1;
		
		for(ShipmentType st:list) {
			Row row=sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(st.getShip_id());
			row.createCell(1).setCellValue(st.getShipment_Mode());
			row.createCell(2).setCellValue(st.getShipment_Code());
			row.createCell(3).setCellValue(st.getEnb_Shipment());
			row.createCell(4).setCellValue(st.getShipment_Grade());
			row.createCell(5).setCellValue(st.getDiscription());
		}

	}

}
