package url.ingsoftware.rrhh.RRHH_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import url.ingsoftware.rrhh.RRHH_Backend.exception.ResourceNotFoundException;
import url.ingsoftware.rrhh.RRHH_Backend.model.Schedules;
import url.ingsoftware.rrhh.RRHH_Backend.repository.ScheduleRepository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // get all schedules
    @GetMapping("/schedules")
    public List<Schedules> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // create schedule
    @PostMapping("/schedules")
    public Schedules createSchedule(@RequestBody Schedules schedule) {
        return scheduleRepository.save(schedule);
    }

    // get schedule by id
    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedules> getScheduleById(@PathVariable Long id) {
        Schedules schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not exist with id :" + id));
        return ResponseEntity.ok(schedule);
    }

    // update schedule
    @PutMapping("/schedules/{id}")
    public ResponseEntity<Schedules> updateSchedule(@PathVariable Long id, @RequestBody Schedules scheduleDetails) {
        Schedules schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not exist with id :" + id));

        schedule.setScheduleDescription(scheduleDetails.getScheduleDescription());
        schedule.setStartTime(scheduleDetails.getStartTime());
        schedule.setEndTime(scheduleDetails.getEndTime());

        Schedules updatedSchedule = scheduleRepository.save(schedule);
        return ResponseEntity.ok(updatedSchedule);
    }

    // delete schedule
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSchedule(@PathVariable Long id) {
        Schedules schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not exist with id :" + id));

        scheduleRepository.delete(schedule);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
