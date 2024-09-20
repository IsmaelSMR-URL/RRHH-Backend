package url.ingsoftware.rrhh.RRHH_Backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;
    private String roleDesc; // Add this field

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

    public String getRoleDesc() { // Add this getter
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) { // Add this setter
        this.roleDesc = roleDesc;
    }
}