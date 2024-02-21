package com.hiasia.peopleflowstatistics.result;

import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonNumberRes {
  private Integer totalPersonNumber;
  private Integer predictionPersonNumber;
  private PersonEnum personEnum;

  public void initPersonNumberRes(List<PersonFlow> personFlows) {
    this.updateTotalPersonNumber(personFlows);
    this.updatePersonEnum();
  }

  public void updateTotalPersonNumber(List<PersonFlow> personFlows) {
    this.totalPersonNumber = personFlows.stream().mapToInt(PersonFlow::getPersonNum).sum();
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime twelveClock = now.minusDays(1).with(LocalTime.of(12, 0));
    LocalDateTime fourteenClock = now.minusDays(1).with(LocalTime.of(14, 0));
    LocalDateTime seventeenClock = now.minusDays(1).with(LocalTime.of(17, 0));
    LocalDateTime twentyOneClock = now.minusDays(1).with(LocalTime.of(21, 0));
    Integer quickPersonNumber =
        personFlows.stream()
            .filter(
                x -> {
                  LocalDateTime dateTime = x.getCreatedTime();
                  boolean one =
                      (dateTime.isAfter(twelveClock) || dateTime.equals(twelveClock))
                          && (dateTime.isBefore(fourteenClock) || dateTime.equals(fourteenClock));
                  boolean two =
                      (dateTime.isAfter(seventeenClock) || dateTime.equals(seventeenClock))
                          && (dateTime.isBefore(twentyOneClock) || dateTime.equals(twentyOneClock));
                  return one || two;
                })
            .mapToInt(PersonFlow::getPersonNum)
            .sum();
    this.predictionPersonNumber =
        (this.totalPersonNumber - quickPersonNumber) + quickPersonNumber / 2;
  }

  public void updatePersonEnum() {
    int totalAmount = this.predictionPersonNumber * 12;
    if (totalAmount < 1000) {
      this.personEnum = PersonEnum.DEFICIT;
    } else if (this.totalPersonNumber < 1500) {
      this.personEnum = PersonEnum.POOR;
    } else if (this.totalPersonNumber < 2000) {
      this.personEnum = PersonEnum.NORMAL;
    } else if (this.totalPersonNumber < 2500) {
      this.personEnum = PersonEnum.BETTER;
    } else if (this.totalPersonNumber < 3000) {
      this.personEnum = PersonEnum.FINE;
    } else {
      this.personEnum = PersonEnum.HOT;
    }
  }
}
