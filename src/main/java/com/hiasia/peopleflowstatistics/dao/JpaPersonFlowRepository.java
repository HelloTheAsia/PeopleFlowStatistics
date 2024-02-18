package com.hiasia.peopleflowstatistics.dao;

import com.hiasia.peopleflowstatistics.bean.JpaPersonFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPersonFlowRepository extends JpaRepository<JpaPersonFlow, Long> {
}
