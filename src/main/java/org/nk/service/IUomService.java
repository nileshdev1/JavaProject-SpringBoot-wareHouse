package org.nk.service;

import java.util.List;

import org.nk.model.Uom;

public interface IUomService {

	public Integer saveUom(Uom uom);
	public List<Uom> getAllUom();
}
