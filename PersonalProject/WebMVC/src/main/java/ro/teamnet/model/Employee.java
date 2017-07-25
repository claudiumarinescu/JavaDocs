package ro.teamnet.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name="EMPLOYEE_ID")
    private Long id;
    @Column (name="FIRST_NAME")
    private String firstName;
    @Column (name="LAST_NAME")
    private String lastName;
    @ManyToOne
    @JoinColumn(name="JOB_ID")
    private Job job;
    @ManyToOne
    @JoinColumn(name="MANAGER_ID")
    private Employee manager;
    @Column (name="HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

//    public Long getManager() {
//        return manager;
//    }
//
//    public void setManager(Long manager) {
//        this.manager = manager;
//    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
