package com.hiasia.peopleflowstatistics.dao;

import com.hiasia.peopleflowstatistics.bean.JpaPersonFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPersonFlowRepository extends JpaRepository<JpaPersonFlow, Long>, JpaSpecificationExecutor<JpaPersonFlow> {
    @Query("SELECT e FROM JpaPersonFlow e WHERE e.createdTime BETWEEN :startDate AND :endDate")
    List<JpaPersonFlow> findDataBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
