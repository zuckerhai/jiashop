package com.plutus.dao;

import com.plutus.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public abstract interface UserDao
{
  public abstract User findById(@Param("id") Long paramLong);

  public abstract User findByUserNameAndPassword(@Param("userName") String paramString);
}