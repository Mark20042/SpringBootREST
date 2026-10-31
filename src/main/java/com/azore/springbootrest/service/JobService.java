package com.azore.springbootrest.service;


import com.azore.springbootrest.model.JobPost;
import com.azore.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {
      @Autowired
      private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJobById(int id) {
        return repo.getJobById(id);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int id) {
        // Logic to delete a job post from the database
        repo.deleteJob(id);
    }
}
