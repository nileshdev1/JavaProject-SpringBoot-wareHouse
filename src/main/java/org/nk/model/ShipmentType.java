package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="shipment_tab")
public class ShipmentType {
	
	@Id
	@GeneratedValue
	@Column(name="ship_id_col")
	private Integer ship_id;
	@Column(name="ship_mode_col")
	private String shipment_Mode;
	@Column(name="ship_code_col")
	private String shipment_Code;
	@Column(name="enb_ship_col")
	private String enb_Shipment;
	@Column(name="ship_grade_col")
	private String shipment_Grade;
	@Column(name="description_col")
	private String discription;
}
