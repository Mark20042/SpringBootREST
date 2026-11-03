package com.azore.springbootrest.service;


import com.azore.springbootrest.model.JobPost;
import com.azore.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@Service
public class JobService {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Develop and maintain software applications", 2, Arrays.asList("Java", "Spring Boot", "SQL")),
            new JobPost(2, "Frontend Developer", "Create and optimize user interfaces", 1, Arrays.asList("JavaScript", "React", "CSS")),
            new JobPost(3, "Data Analyst", "Analyze and interpret complex data sets", 3, Arrays.asList("Python", "SQL", "Excel"))
    ));

      @Autowired
      private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJobById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int id) {
        // Logic to delete a job post from the database
        repo.deleteById(id);
    }


    public void load() {
        // Logic to load data into the database
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keywords) {

       return repo.findByPostProfileContainingOrPostDescContaining(keywords, keywords);
    }
}
