package com.blueyonder.JobApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "jobinfo")
@NoArgsConstructor
@AllArgsConstructor


public class Jobinfo {
    @Id
    @GeneratedValue
    public int id;
    @NotNull(message = "Job title cannot be null")
    public String jobtitle;
    @NotBlank(message = "Job category cannot be blank")
    public String jobcategory;
    public String jobdescription;
    public List<String> joblocation;
    public String jobtype;
    @Min(0)
    @Max(20)
    public int jobexperience;
    @Min(10000)
    public double jobsalary;
    public List<String> jobskills;
    public String jobcompany;
    public Date jobposteddate;
    public Date jobclosingdate;
    public String joblink;
    public String jobstatus;
}