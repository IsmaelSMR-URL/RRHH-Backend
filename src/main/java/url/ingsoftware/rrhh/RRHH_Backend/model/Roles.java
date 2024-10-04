package url.ingsoftware.rrhh.RRHH_Backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;
    private String roleDescription; // Add this field

    // Getters and Setters
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() { // Add this getter
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) { // Add this setter
        this.roleDescription = roleDescription;
    }
}