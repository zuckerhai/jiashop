package com.hai.model;

public class ComplexButton extends Button
{
  private String name;
  private Button[] sub_button;

  public String getName()
  {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Button[] getSub_button() {
    return this.sub_button;
  }
  public void setSub_button(Button[] sub_button) {
    this.sub_button = sub_button;
  }
}