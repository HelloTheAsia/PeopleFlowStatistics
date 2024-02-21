package com.hiasia.peopleflowstatistics.bean;

import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "person_flow")
public class JpaPersonFlow {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String image;
  private Integer personNum;
  private String logId;
  private LocalDateTime createdTime;

  public JpaPersonFlow(PersonFlow personFlow) {
    this.image = personFlow.getImage();
    this.personNum = personFlow.getPersonNum();
    this.logId = personFlow.getLogId();
    this.createdTime = LocalDateTime.now();
  }

  public PersonFlow toPersonFlow() {
    PersonFlow personFlow = new PersonFlow();
    personFlow.setImage(this.image);
    personFlow.setPersonNum(this.personNum);
    personFlow.setLogId(this.logId);
    personFlow.setCreatedTime(this.createdTime);
    return personFlow;
  }
}
