package com.springpractice.services.impl;

import com.springpractice.models.Job;
import com.springpractice.services.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService
{
    private final List<Job> jobs = new ArrayList<>();

    private long jobIdIncrementer = 1L;

    @Override
    public List<Job> getAll()
    {
        return jobs;
    }

    @Override
    public void createJob(Job job)
    {
        job.setId(jobIdIncrementer += 4);

        jobs.add(job);
    }

    @Override
    public Optional<Job> getById(long id)
    {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst();

    }

    @Override
    public boolean update(Job job, long jobId)
    {
        final boolean[] found = {false};

        jobs.forEach(row ->
        {
            if (row.getId().equals(jobId))
            {
                row.setTitle(job.getTitle());
                row.setDescription(job.getDescription());
                row.setMinSalary(job.getMinSalary());
                row.setMaxSalary(job.getMaxSalary());
                row.setLocation(job.getLocation());

                found[0] = true;
            }
        });

        return found[0];
    }

    @Override
    public boolean deleteById(long jobId)
    {
        return jobs.removeIf(job -> job.getId().equals(jobId));
    }
}
