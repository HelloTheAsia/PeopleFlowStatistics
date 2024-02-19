package com.hiasia.peopleflowstatistics.dao;

import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import java.util.List;

public interface PersonFlowRepository {
  void save(PersonFlow personFlow);

  List<PersonFlow> findDataBetweenDates();
}
