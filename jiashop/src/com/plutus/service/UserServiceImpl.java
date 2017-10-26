package com.plutus.service;

import com.plutus.dao.UserDao;
import com.plutus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl
  implements UserService
{

  @Autowired
  private UserDao userDao;

  public User findById(Long id)
  {
    return null;
  }

  public User findByUserNameAndPassword(String userName, String password)
  {
    User user = this.userDao.findByUserNameAndPassword(userName);
    if (user != null) {
      if (password.equals(user.getPassword())) {
        return user;
      }
      return null;
    }

    return user;
  }
}