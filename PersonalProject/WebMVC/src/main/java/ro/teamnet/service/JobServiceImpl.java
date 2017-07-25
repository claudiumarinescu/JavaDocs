package ro.teamnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.teamnet.dao.interfaces.JobRepository;
import ro.teamnet.model.Job;
import ro.teamnet.service.interfaces.JobService;

import java.util.List;


@Service
@Transactional
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> listAllJobs() {
        return jobRepository.listAllJobs();
    }

    public void saveOrUpdate(Job job) {
        jobRepository.saveOrUpdate(job);
    }

    public Job findJobById(Long id) {
        return jobRepository.findJobById(id);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteJob(id);
    }

}
