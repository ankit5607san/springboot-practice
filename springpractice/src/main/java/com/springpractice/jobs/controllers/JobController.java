package com.springpractice.jobs.controllers;


import com.springpractice.jobs.models.Job;
import com.springpractice.jobs.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController
{
    private final JobService jobService;

    public JobController(JobService jobService)
    {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getJobs()
    {
        return ResponseEntity.ok(jobService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);

        return ResponseEntity.ok("job added successfully");
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId)
    {
        Optional<Job> optionalJob = jobService.getById(jobId);

        return optionalJob.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteById(@PathVariable long jobId)
    {
        if (jobService.deleteById(jobId))
        {
            return ResponseEntity.ok("deleted id [" + jobId + "] successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable long jobId)
    {
        if (jobService.update(job, jobId))
        {
            return ResponseEntity.ok("updated job [" + jobId + "] successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
