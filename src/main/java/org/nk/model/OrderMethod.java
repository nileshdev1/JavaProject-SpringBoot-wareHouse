package org.nk.model;


import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_method_tab")
public class OrderMethod {

	@Id
	@GeneratedValue
	@Column(name="order_id_col", nullable=false)
	private Integer order_Method_Id;
	@Column(name="order_mode_col", nullable=false)
	private String order_Mode;
	@Column(name="order_code_col", nullable=false)
	private String order_Code;
	@Column(name="order_method_col", nullable=false)
	private String order_Method;
	@ElementCollection
	@CollectionTable(name="order_acpt_tab", joinColumns=@JoinColumn(name="ord_id_col"))
	@Column(name="order_accept_col", nullable=false)
	private List<String> order_Accept;
	@Column(name="description_col", nullable=false)
	private String description;
	
}
