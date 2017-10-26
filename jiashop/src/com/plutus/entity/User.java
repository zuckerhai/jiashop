package com.plutus.entity;

public class User
{
  private Long id;
  private String userName;
  private String password;

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId()
  {
    return this.id;
  }

  public String getUserName() {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }
}