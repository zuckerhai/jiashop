package com.plutus.service;

import com.plutus.entity.MyFile;

public abstract interface FileService
{
  public abstract Integer insertFile(MyFile paramMyFile);

  public abstract MyFile findById(Long paramLong);

  public abstract Integer deleteById(Long paramLong);
}