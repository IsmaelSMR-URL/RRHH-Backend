package url.ingsoftware.rrhh.RRHH_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import url.ingsoftware.rrhh.RRHH_Backend.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}