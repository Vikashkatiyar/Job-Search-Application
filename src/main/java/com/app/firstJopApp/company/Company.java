package com.app.firstJopApp.company;

import java.util.List;

import com.app.firstJopApp.job.Job;
import com.app.firstJopApp.review.Review;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@JsonManagedReference
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL) // one company has many jobs
	private List<Job> jobs;

	@OneToMany(mappedBy = "company") // one company has many review
	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Company() {
		// for Data JPA
	}

	public Company(Long id, String name, String description, List<Job> jobs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}
