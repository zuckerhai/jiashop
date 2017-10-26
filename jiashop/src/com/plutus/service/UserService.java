package com.plutus.service;

import com.plutus.entity.User;

public abstract interface UserService
{
  public abstract User findById(Long paramLong);

  public abstract User findByUserNameAndPassword(String paramString1, String paramString2);
}