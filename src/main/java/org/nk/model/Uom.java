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
 * @UOM
 */

@Data
@Entity
@Table(name="uom_tab")
public class Uom {

	@Id
	@GeneratedValue
	@Column(name="uom_id", nullable=false)
	private Integer uom_Id;
	@Column(name="uom_type", nullable=false)
	private String uom_Type;
	@Column(name="uom_model", nullable=false)
	private String uom_Model;
	@Column(name="uom_desc", nullable=false)
	private String description;
}
