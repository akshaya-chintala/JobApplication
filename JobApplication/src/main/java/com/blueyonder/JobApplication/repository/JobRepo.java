package com.blueyonder.JobApplication.repository;

import com.blueyonder.JobApplication.model.Jobinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepo extends JpaRepository<Jobinfo, Integer> {
//    @Query("SELECT j FROM Jobinfo j WHERE :location MEMBER OF j.joblocation")
//    List<Jobinfo> findByJoblocation(@Param("location") String location);

    @Query("SELECT j FROM Jobinfo j WHERE j.jobcategory = :category")
    List<Jobinfo> findByJobcategory(@Param("category") String category);

    @Query("SELECT j FROM Jobinfo j WHERE :location MEMBER OF j.joblocation")
    Jobinfo findByJoblocation(List location);
}
