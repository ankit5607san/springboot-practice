package com.springpractice.controllers;

import com.springpractice.models.Job;
import com.springpractice.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController
{
    private final JobService jobService;

    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs()
    {
        return ResponseEntity.ok(jobService.getAll());
    }

    @PostMapping("/jobs/create")
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);

        return ResponseEntity.ok("job added successfully");
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId)
    {
        Optional<Job> optionalJob = jobService.getById(jobId);

        return optionalJob.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<String> deleteById(@PathVariable long jobId)
    {
        if (jobService.deleteById(jobId))
        {
            return ResponseEntity.ok("deleted id [" + jobId + "] successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PutMapping("/jobs/{jobId}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable long jobId)
    {
        if (jobService.update(job, jobId))
        {
            return ResponseEntity.ok("updated job [" + jobId + "] successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
