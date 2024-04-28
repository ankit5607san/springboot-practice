package com.springpractice.jobs.services.impl;

import com.springpractice.jobs.models.Job;
import com.springpractice.jobs.repositories.JobRepository;
import com.springpractice.jobs.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService
{
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository)
    {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAll()
    {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job)
    {
        jobRepository.save(job);
    }

    @Override
    public Optional<Job> getById(long id)
    {
        return jobRepository.findById(id);
    }

    @Override
    public boolean update(Job job, long jobId)
    {
        Optional<Job> optionalJob = jobRepository.findById(jobId);

        if (optionalJob.isPresent())
        {
            optionalJob.get().setTitle(job.getTitle());
            optionalJob.get().setDescription(job.getDescription());
            optionalJob.get().setMinSalary(job.getMinSalary());
            optionalJob.get().setMaxSalary(job.getMaxSalary());
            optionalJob.get().setLocation(job.getLocation());

            jobRepository.save(optionalJob.get());

            return true;
        }

        return false;
    }

    @Override
    public boolean deleteById(long jobId)
    {
        if (jobRepository.existsById(jobId))
        {
            jobRepository.deleteById(jobId);

            return true;
        }

        return false;
    }
}
