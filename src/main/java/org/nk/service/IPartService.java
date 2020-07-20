package org.nk.service;

import java.util.List;
import java.util.Optional;

import org.nk.model.Part;

public interface IPartService {

	public Integer savePart(Part prt);
	public void deletePart(Integer id);
	public void updatePart(Part prt);
	public Optional<Part> getOnePart(Integer id);
	public List<Part> getAllPart();
}
