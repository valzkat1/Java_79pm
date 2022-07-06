package org.fundacionview.ejemplo1.repositorios;

import org.fundacionview.ejemplo1.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmpleados extends JpaRepository<Empleado, Integer>{

}
