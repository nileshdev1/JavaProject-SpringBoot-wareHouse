package org.nk.repo;

import java.util.List;

import org.nk.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	@Query(" select doc.docId,doc.docName from org.nk.model.Document doc ")
	List<Object[]> findIdAndName();
}
