package com.app.firstJopApp.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.firstJopApp.job.Job;
import com.app.firstJopApp.job.JobRepository;
import com.app.firstJopApp.job.JobService;

@Service
public class JobServiceImpl implements JobService{
     
	private JobRepository jobRepository;
	
	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	
	
	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long id, Job updatedJobs) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		
		if(jobOptional.isPresent()) {
			Job job=jobOptional.get();
			
			job.setTitle(updatedJobs.getTitle());
			job.setDescription(updatedJobs.getDescription());
			job.setMinSalary(updatedJobs.getMinSalary());
			job.setMaxSalary(updatedJobs.getMaxSalary());
			job.setLocation(updatedJobs.getLocation());
			
			jobRepository.save(job);
			return true;
		}
		return false;
	}
	
	

}
