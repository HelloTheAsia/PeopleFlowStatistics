package com.hiasia.peopleflowstatistics.result;

public enum PersonEnum {
  DEFICIT("有点亏"),
  POOR("较差"),
  NORMAL("正常"),
  BETTER("较好"),
  FINE("很好"),
  HOT("生意火爆"),
  ;

  private String desc;

  PersonEnum(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return desc;
  }
}
