package ro.teamnet.model;

import javax.persistence.*;

@Entity
@Table (name="JOBS")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="JOB_ID")
    private Long id;
    @Column(name="JOB_TITLE")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
