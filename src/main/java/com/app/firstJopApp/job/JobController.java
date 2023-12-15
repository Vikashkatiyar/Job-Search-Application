package com.app.firstJopApp.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	private JobService jobService;
	
    
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}


	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}
	
	 
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<String>("Job added succeessfully", HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {
		Job job=jobService.getJobById(id);
		if(job!=null) {
			return new ResponseEntity<>(job,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJobById(@PathVariable Long id){
		boolean job=jobService.deleteById(id);
		if(job) {
			return ResponseEntity.ok("Record Deleted Successfully");
		}
		return new ResponseEntity<String>("Record not exit already", HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job updatedJobs){
		boolean update=jobService.updateJobById(id,updatedJobs);
		if(update) {
			return new ResponseEntity<String>("Job updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Job id not correct", HttpStatus.NOT_FOUND);
	}
	
	
}
