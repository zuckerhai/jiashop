package com.plutus.dao;

import com.plutus.entity.MyFile;
import org.springframework.stereotype.Repository;

@Repository("fileDao")
public abstract interface FileDao
{
  public abstract Integer insertFile(MyFile paramMyFile);

  public abstract MyFile findById(Long paramLong);

  public abstract Integer deleteById(Long paramLong);
}