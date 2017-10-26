package com.hai.model;

public class CommonButton extends Button
{
  private String type;
  private String key;

  public String getKey()
  {
    return this.key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public String getType() {
    return this.type;
  }
  public void setType(String type) {
    this.type = type;
  }
}