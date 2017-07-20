package ro.teamnet.zth.appl;

import javax.persistence.*;

/**
 * Created by Claudiu.Marinescu on 7/19/2017.
 */
@Entity
@Table (name="TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TASK_ID")
    private Long id;
    @Column (name="TASK_NAME")
    private String name;
    @Column (name="PROJECT_ID")
    private Project project;
    @Column (name="EXECUTIVE_ID")
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
