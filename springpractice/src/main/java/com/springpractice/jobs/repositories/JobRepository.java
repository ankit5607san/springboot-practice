package com.springpractice.jobs.repositories;


import com.springpractice.jobs.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>
{
}
