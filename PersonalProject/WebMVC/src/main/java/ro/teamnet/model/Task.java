package ro.teamnet.model;

import javax.persistence.*;

@Entity
@Table(name="TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TASK_ID")
    private Long id;
    @Column(name="TASK_NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name="PROJECT_ID")
    private Project project;
    @ManyToOne
    @JoinColumn(name="EXECUTIVE_ID")
    private Employee executive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getExecutive() {
        return executive;
    }

    public void setExecutive(Employee executive) {
        this.executive = executive;
    }
}
