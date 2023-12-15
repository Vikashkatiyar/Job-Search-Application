package com.app.firstJopApp.job;

import java.util.List;

public interface JobService {
	List<Job> findAll();

	void createJob(Job job);

	Job getJobById(Long id);

	boolean deleteById(Long id);

	boolean updateJobById(Long id, Job updatedJobs);

	
}
