package org.nk.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.nk.model.WhUserType;

public interface IWhUserTypeService {

	public Integer saveWhUserType(WhUserType whuser);
	public void deleteWhUserType(Integer id);
	public void updateWhUserType(WhUserType whuser);
	public Optional<WhUserType> getOneWhUserType(Integer id);
	public List<WhUserType> getAllWhUserType();
	public List<Object[]> getWhUserCount();
	public 	Map<Integer,String> getWhUserTypeIdAndCode(String userType);
}
