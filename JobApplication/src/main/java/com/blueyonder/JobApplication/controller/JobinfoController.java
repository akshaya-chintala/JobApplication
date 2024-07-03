package com.blueyonder.JobApplication.controller;

import com.blueyonder.JobApplication.model.Jobinfo;
import com.blueyonder.JobApplication.service.JobinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobinfoController {

    private final JobinfoService jobinfoService;

    @Autowired
    public JobinfoController(JobinfoService jobinfoService) {
        this.jobinfoService = jobinfoService;
    }

    @PostMapping("/addjob")
    public Jobinfo addJob(@RequestBody Jobinfo job) {
        return jobinfoService.saveJob(job);
    }

    @PostMapping("/addjobs")
    public List<Jobinfo> addJobs(@RequestBody List<Jobinfo> jobs) {
        return jobinfoService.saveJobs(jobs);
    }

    @GetMapping("/findalljobs")
    public List<Jobinfo> findAllJobs() {
        return jobinfoService.getJobs();
    }

    @GetMapping("/findjobbyid/{id}")
    public Jobinfo findJobById(@PathVariable int id) {
        return jobinfoService.getJobById(id);
    }

    @GetMapping("/location/{location}")
    public Jobinfo getJobsByLocation(@PathVariable List location) {
        return jobinfoService.findJobsByLocation(location);
    }

    @GetMapping("/category/{category}")
    public List<Jobinfo> getJobsByCategory(@PathVariable String category) {
        return jobinfoService.findJobsByCategory(category);
    }

    @PutMapping("/updatejob/{id}")
    public Jobinfo updateJob(@RequestBody Jobinfo job, @PathVariable int id) {
        return jobinfoService.updateJob(job, id);
    }

    @DeleteMapping("/deletejob/{id}")
    public String deleteJob(@PathVariable int id) {
        return jobinfoService.deleteJob(id);
    }
}
