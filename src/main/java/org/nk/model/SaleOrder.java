package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sale_order_tab")
public class SaleOrder {

	@Id
	@GeneratedValue
	@Column(name="sorder_Id_Col")
	private Integer sorder_Id;
	@Column(name="sorder_Code_Col")
	private String sorder_Code;
	@Column(name="reference_No_Col")
	private String reference_No;
	@Column(name="stock_Mode_Col")
	private String stock_Mode;
	@Column(name="stock_Source_Col")
	private String stock_Source;
	@Column(name="status_Col")
	private String status;
	@Column(name="description_Col")
	private String description;
}
