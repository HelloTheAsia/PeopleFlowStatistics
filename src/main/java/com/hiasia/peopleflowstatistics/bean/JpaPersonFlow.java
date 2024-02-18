package com.hiasia.peopleflowstatistics.bean;

import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

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
        this.personNum = personFlow.getPerson_num();
        this.logId = personFlow.getLog_id();
        this.createdTime = LocalDateTime.now();
    }

    public PersonFlow toPersonFlow() {
        PersonFlow personFlow = new PersonFlow();
        personFlow.setImage(this.image);
        personFlow.setPerson_num(this.personNum);
        personFlow.setLog_id(this.logId);
        return personFlow;
    }
}
