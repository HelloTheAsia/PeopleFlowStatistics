package com.hiasia.peopleflowstatistics.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PersonFlow {
  private String image;

  @JsonProperty("person_num")
  private Integer personNum;

  @JsonProperty("log_id")
  private String logId;

  private LocalDateTime createdTime;
}
