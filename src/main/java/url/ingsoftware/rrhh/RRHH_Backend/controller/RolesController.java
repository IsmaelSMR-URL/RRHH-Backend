package url.ingsoftware.rrhh.RRHH_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import url.ingsoftware.rrhh.RRHH_Backend.exception.ResourceNotFoundException;
import url.ingsoftware.rrhh.RRHH_Backend.model.Roles;
import url.ingsoftware.rrhh.RRHH_Backend.repository.RolesRepository;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    // get all roles
    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    // create roles
    @PostMapping("/roles")
    public Roles createRole(@RequestBody Roles role) {
        return rolesRepository.save(role);
    }

    // get roles by id
    @GetMapping("/roles/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Roles roles = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles not exist with id :" + id));
        return ResponseEntity.ok(roles);
    }

    // update roles
    @PutMapping("/roles/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Long id, @RequestBody Roles roleDetails) {
        Roles roles = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles not exist with id :" + id));

        roles.setRoleName(roleDetails.getRoleName());
        roles.setRoleDesc(roleDetails.getRoleDesc());

        Roles updatedRoles = rolesRepository.save(roles);
        return ResponseEntity.ok(updatedRoles);
    }

    // delete roles
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRole(@PathVariable Long id) {
        Roles roles = rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles not exist with id :" + id));

        rolesRepository.delete(roles);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
