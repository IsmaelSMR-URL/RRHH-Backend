package url.ingsoftware.rrhh.RRHH_Backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    private String deptName;

    private String deptDescription;

    // Getters and Setters
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }
}