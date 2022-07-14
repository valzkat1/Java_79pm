package org.fundacionview.sgsst.repositorios;

import org.fundacionview.sgsst.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Empleados extends JpaRepository<Empleado, Integer>{

}
