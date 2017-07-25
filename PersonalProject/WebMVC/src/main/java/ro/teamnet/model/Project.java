package ro.teamnet.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PROJECTS")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="PROJECT_ID")
    private Long id;
    @Column (name="PROJECT_NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name="MANAGER_ID")
    private Employee manager;
    @Column (name="DEADLINE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
