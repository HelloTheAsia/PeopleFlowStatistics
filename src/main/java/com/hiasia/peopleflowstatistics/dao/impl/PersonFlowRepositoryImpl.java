package com.hiasia.peopleflowstatistics.dao.impl;

import com.hiasia.peopleflowstatistics.bean.JpaPersonFlow;
import com.hiasia.peopleflowstatistics.dao.JpaPersonFlowRepository;
import com.hiasia.peopleflowstatistics.dao.PersonFlowRepository;
import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonFlowRepositoryImpl implements PersonFlowRepository {
    private final JpaPersonFlowRepository repository;

    @Override
    public void save(PersonFlow personFlow) {

        JpaPersonFlow jpaPersonFlow = new JpaPersonFlow(personFlow);
        repository.save(jpaPersonFlow);
    }

    @Override
    public List<PersonFlow> findDataBetweenDates() {
        LocalDateTime yesterdayAt7AM = LocalDateTime.now().minusDays(1).withHour(7).withMinute(0).withSecond(0);
        LocalDateTime todayAt4AM = LocalDateTime.now().withHour(3).withMinute(0).withSecond(0);
        List<JpaPersonFlow> dataBetweenDates = repository.findDataBetweenDates(yesterdayAt7AM, todayAt4AM);
        return dataBetweenDates.stream().map(JpaPersonFlow::toPersonFlow).collect(Collectors.toList());
    }
}
