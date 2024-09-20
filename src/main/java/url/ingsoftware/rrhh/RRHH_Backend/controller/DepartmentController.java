package url.ingsoftware.rrhh.RRHH_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import url.ingsoftware.rrhh.RRHH_Backend.exception.ResourceNotFoundException;
import url.ingsoftware.rrhh.RRHH_Backend.model.Department;
import url.ingsoftware.rrhh.RRHH_Backend.repository.DepartmentRepository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // get all departments
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // create department
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // get department by id
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
        return ResponseEntity.ok(department);
    }

    // update department
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));

        department.setDeptName(departmentDetails.getDeptName());
        // Ensure deptDescription exists in Department class or remove this line
        // department.setDeptDescription(departmentDetails.getDeptDescription());

        Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    // delete department
    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));

        departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}