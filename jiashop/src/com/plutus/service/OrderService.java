package com.plutus.service;

import com.plutus.dto.CustomerOrderRequest;
import com.plutus.entity.Order;
import java.util.List;

public abstract interface OrderService
{
  public abstract List<Order> findAllWithCustomerPageableByCustomerId(CustomerOrderRequest paramCustomerOrderRequest);

  public abstract Integer findCountByCustomerId(CustomerOrderRequest paramCustomerOrderRequest);

  public abstract Integer addOrder(Order paramOrder);

  public abstract Order getSinglePro(CustomerOrderRequest paramCustomerOrderRequest);
}