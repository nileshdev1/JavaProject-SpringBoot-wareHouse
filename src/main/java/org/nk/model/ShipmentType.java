package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * @Class:   Model/Entity
 * @Author:  Nil
 * @Version: 1.0
 * @ShipmentType
 */
@Entity
@Data
@Table(name="shipment_tab")
public class ShipmentType {
	
	@Id
	@GeneratedValue
	@Column(name="ship_id_col", nullable=false)
	private Integer ship_id;
	@Column(name="ship_mode_col", nullable=false)
	private String shipment_Mode;
	@Column(name="ship_code_col", nullable=false)
	private String shipment_Code;
	@Column(name="enb_ship_col", nullable=false)
	private String enb_Shipment;
	@Column(name="ship_grade_col", nullable=false)
	private String shipment_Grade;
	@Column(name="description_col", nullable=false)
	private String discription;
}
