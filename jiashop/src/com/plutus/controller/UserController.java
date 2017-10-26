package com.plutus.controller;

import com.plutus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/user"})
public class UserController
{

  @Autowired
  private UserService userService;
}