package org.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="uom_tab")
public class Uom {

	@Id
	@GeneratedValue
	@Column(name="uom_id")
	private Integer uom_Id;
	@Column(name="uom_type")
	private String uom_Type;
	@Column(name="uom_model")
	private String uom_Model;
	@Column(name="uom_desc")
	private String description;
}
