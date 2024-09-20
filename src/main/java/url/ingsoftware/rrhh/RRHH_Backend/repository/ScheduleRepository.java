package url.ingsoftware.rrhh.RRHH_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import url.ingsoftware.rrhh.RRHH_Backend.model.Schedules;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    // Métodos CRUD ya proporcionados por JpaRepository
}
