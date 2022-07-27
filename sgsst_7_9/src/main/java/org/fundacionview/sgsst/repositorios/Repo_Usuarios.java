package org.fundacionview.sgsst.repositorios;

import org.fundacionview.sgsst.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Usuarios extends JpaRepository<Usuario, Long>{

	@Query(value = "FROM Usuario WHERE id_empleado=:idEmp")
	public Usuario buscarPorId_Empleado(@Param("idEmp")Long idEmp);
	
	//public Usuario findById_empleado(Long id_empleado);
	
	
}
