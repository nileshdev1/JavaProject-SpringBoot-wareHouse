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
@Table(name="part_tab")
public class Part {

	@Id
	@GeneratedValue
	@Column(name="part_id_col")
	private Integer part_Id;
	@Column(name="part_code_col")
	private String part_Code;
	@Column(name="part_wdth_col")
	private Double part_Wdth;
	@Column(name="part_Len_col")
	private Double part_Len;
	@Column(name="part_Hgh_col")
	private Double part_Hgh;
	@Column(name="part_Cost_col")
	private Double base_Cost;
	@Column(name="part_Curr_col")
	private String base_Curr;
	@Column(name="part_desc_col")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="uomidfk")
	private Uom uomob;
}
