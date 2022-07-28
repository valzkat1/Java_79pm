package org.fundacionview.sgsst.repositorios;

import java.util.ArrayList;
import java.util.Date;

import org.fundacionview.sgsst.modelos.Ausentismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Ausentismos extends JpaRepository<Ausentismo, Integer>{

	
	public ArrayList<Ausentismo> findByAreaTrabajo(String areaTrabajo);
	
	
	@Query("FROM Ausentismo  WHERE  areaTrabajo=:area AND fechaRegistro BETWEEN :FechaIn AND :fechaFin")
	public ArrayList<Ausentismo> consultaConfechas(@Param("area")String area,@Param("FechaIn")Date FechaIn,@Param("fechaFin")Date fechaFin);
	
	
}
