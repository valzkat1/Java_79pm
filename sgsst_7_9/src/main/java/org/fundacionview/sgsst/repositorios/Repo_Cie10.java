package org.fundacionview.sgsst.repositorios;

import java.util.ArrayList;

import org.fundacionview.sgsst.modelos.CIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Cie10  extends JpaRepository<CIE10, Integer> {

	
	@Query(value = "FROM CIE10 WHERE diagnostico like :diagnostico")
	public ArrayList<CIE10> getDiagnostico(@Param("diagnostico")String diagnostico);
	
	
}
