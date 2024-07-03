package com.blueyonder.JobApplication.service;

import com.blueyonder.JobApplication.model.Jobinfo;
import com.blueyonder.JobApplication.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobinfoService {

    private final JobRepo jobRepo;

    @Autowired
    public JobinfoService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public Jobinfo findJobsByLocation(List location) {
        return jobRepo.findByJoblocation(location);
    }

    public List<Jobinfo> findJobsByCategory(String category) {
        return jobRepo.findByJobcategory(category);
    }

    public Jobinfo saveJob(Jobinfo job) {
        return jobRepo.save(job);
    }

    public List<Jobinfo> saveJobs(List<Jobinfo> jobs) {
        return jobRepo.saveAll(jobs);
    }

    public List<Jobinfo> getJobs() {
        return jobRepo.findAll();
    }

    public Jobinfo getJobById(int id) {
        return jobRepo.findById(id).orElse(null);
    }

    public Jobinfo updateJob(Jobinfo job, int id) {
        Jobinfo existingJob = jobRepo.findById(id).orElse(null);
        if (existingJob != null) {
            existingJob.setJobtitle(job.getJobtitle());
            existingJob.setJobdescription(job.getJobdescription());
            existingJob.setJoblocation(job.getJoblocation());
            existingJob.setJobtype(job.getJobtype());
            existingJob.setJobexperience(job.getJobexperience());
            existingJob.setJobsalary(job.getJobsalary());
            existingJob.setJobskills(job.getJobskills());
            existingJob.setJobcompany(job.getJobcompany());
            existingJob.setJobposteddate(job.getJobposteddate());
            existingJob.setJobclosingdate(job.getJobclosingdate());
            existingJob.setJoblink(job.getJoblink());
            existingJob.setJobstatus(job.getJobstatus());
            return jobRepo.save(existingJob);
        } else {
            return null;
        }
    }

    public String deleteJob(int id) {
        jobRepo.deleteById(id);
        return "Job removed !! " + id;
    }
}
