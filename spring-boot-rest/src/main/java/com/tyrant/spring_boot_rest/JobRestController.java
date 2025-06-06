package com.tyrant.spring_boot_rest;

import com.tyrant.spring_boot_rest.model.JobPost;
import com.tyrant.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")

    public List<JobPost> getAllJobs() {
    return jobService.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }
    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        jobService.deleteJob(postId);
        return "Job listing deleted successfully";
    }
}
