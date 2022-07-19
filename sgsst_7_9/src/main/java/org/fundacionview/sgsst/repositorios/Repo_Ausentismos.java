package org.fundacionview.sgsst.repositorios;

import org.fundacionview.sgsst.modelos.Ausentismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Ausentismos extends JpaRepository<Ausentismo, Integer>{

	
	
}
