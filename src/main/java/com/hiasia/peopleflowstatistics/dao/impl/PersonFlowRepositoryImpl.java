package com.hiasia.peopleflowstatistics.dao.impl;

import com.hiasia.peopleflowstatistics.bean.JpaPersonFlow;
import com.hiasia.peopleflowstatistics.dao.JpaPersonFlowRepository;
import com.hiasia.peopleflowstatistics.dao.PersonFlowRepository;
import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonFlowRepositoryImpl implements PersonFlowRepository {
    private final JpaPersonFlowRepository repository;

    @Override
    public void save(PersonFlow personFlow) {

        JpaPersonFlow jpaPersonFlow = new JpaPersonFlow(personFlow);
        repository.save(jpaPersonFlow);
    }
}
