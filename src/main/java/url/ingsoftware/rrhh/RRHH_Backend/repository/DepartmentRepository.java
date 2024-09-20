package url.ingsoftware.rrhh.RRHH_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import url.ingsoftware.rrhh.RRHH_Backend.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Métodos CRUD ya proporcionados por JpaRepository
}
