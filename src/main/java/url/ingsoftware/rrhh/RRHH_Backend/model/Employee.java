package url.ingsoftware.rrhh.RRHH_Backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String empName;

    private String empLastName;

    private String phoneNumber;

    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "Departments_deptId", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "Roles_roleId", nullable = false)
    private Roles roles;

    @ManyToOne
    @JoinColumn(name = "Schedules_scheduleId", nullable = false)
    private Schedules schedule;

    // Getters and Setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Schedules getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedules schedule) {
        this.schedule = schedule;
    }
}