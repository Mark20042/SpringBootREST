package com.azore.springbootrest.repo;


import com.azore.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class JobRepo {


    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Develop and maintain software applications", 2, Arrays.asList("Java", "Spring Boot", "SQL")),
            new JobPost(2, "Frontend Developer", "Create and optimize user interfaces", 1, Arrays.asList("JavaScript", "React", "CSS")),
            new JobPost(3, "Data Analyst", "Analyze and interpret complex data sets", 3, Arrays.asList("Python", "SQL", "Excel"))
    ));


    public List<JobPost> getAllJobs() {
        // Logic to retrieve all job posts from the database
        return jobs;
    }


    public void addJob(JobPost job) {
        // Logic to add a job post to the database
        jobs.add(job);
        System.out.println("Job added: " + job);
    }


    public JobPost getJobById(int postId) {
        // Logic to retrieve a job post by its ID from the database
        for (JobPost job : jobs) {
            if (job.getPostId() == postId) {
                return job;
            }
        }
        return null; // Return null if the job post is not found
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobs) {
            if (jobPost1.getPostId() == jobPost.getPostId()) {
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int id) {
        for (JobPost jobPost : jobs) {
            if (jobPost.getPostId() == id) {
                jobs.remove(jobPost);
                break;
            }
        }
    }
}
