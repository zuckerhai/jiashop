package com.plutus.dto;

public class UserDto
{
  private String userName;
  private String password;

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }
}