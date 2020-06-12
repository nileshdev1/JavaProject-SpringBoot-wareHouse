package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.Uom;

/*
 * @Interface:  Service
 * @Author:  Nil
 * @Version: 1.0
 * @UOM
 */

public interface IUomService {

	public Integer saveUom(Uom uom);
	public List<Uom> getAllUom();
	public void deleteUom(Integer id);
	public void updateUom(Uom uom);
	public Optional<Uom> getOneUom(Integer id);
	
	
}
