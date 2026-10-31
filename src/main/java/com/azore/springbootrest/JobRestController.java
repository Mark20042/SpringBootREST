package com.azore.springbootrest;


import com.azore.springbootrest.model.JobPost;
import com.azore.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }


    @GetMapping("jobs/{id}")
    @ResponseBody
    public JobPost getJobById(@PathVariable("id") int id) {
        return jobService.getJobById(id);
    }


    @PostMapping("jobs")
    @ResponseBody
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }


    @PutMapping("jobs")
    @ResponseBody
    public JobPost updateJob( @RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }


    @DeleteMapping("jobs/{id}")
    @ResponseBody
    public String deleteJob(@PathVariable("id") int id) {
        jobService.deleteJob(id);
        return "Job with ID " + id + " has been deleted.";
    }

}
