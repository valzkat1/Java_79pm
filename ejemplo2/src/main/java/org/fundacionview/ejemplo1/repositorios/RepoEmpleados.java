package org.fundacionview.ejemplo1.repositorios;

import org.fundacionview.ejemplo1.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmpleados extends JpaRepository<Empleado, Integer>{

	// Hibernate query lenguage
	// Select *from
	@Query("FROM Empleado where email=:email AND clave=:clave")
	public Empleado confirmarLogin(@Param("email")String email,@Param("clave")String clave);
	
}
