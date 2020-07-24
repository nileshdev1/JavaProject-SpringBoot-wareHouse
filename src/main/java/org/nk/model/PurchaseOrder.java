package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="purchase_order_tab")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name="order_Id_Col")
	private Integer porder_Id;
	@Column(name="order_Code_Col")
	private String porder_Code;
	@Column(name="reference_No_Col")
	private String reference_No;
	@Column(name="qty_Check_Col")
	private String qty_Check;
	@Column(name="status_Col")
	private String status;
	@Column(name="description_Col")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="shipment_type_id_fk")
	private ShipmentType shipmentType;
	
	@ManyToOne
	@JoinColumn(name="whuser_type_id_fk")
	private WhUserType vender;
}
