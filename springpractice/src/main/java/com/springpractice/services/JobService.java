package com.springpractice.services;

import com.springpractice.models.Job;

import java.util.List;
import java.util.Optional;

public interface JobService
{
    List<Job> getAll();

    void createJob(Job job);

    Optional<Job> getById(long id);

    boolean update(Job job, long jobId);

    boolean deleteById(long jobId);
}
