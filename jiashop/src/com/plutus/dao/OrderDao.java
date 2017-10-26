package com.plutus.dao;

import com.plutus.dto.CustomerOrderRequest;
import com.plutus.entity.Order;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public abstract interface OrderDao
{
  public abstract List<Order> findAllWithCustomerPageableByCustomerId(CustomerOrderRequest paramCustomerOrderRequest);

  public abstract Integer findCountByCustomerId(CustomerOrderRequest paramCustomerOrderRequest);

  public abstract Integer addOrder(Order paramOrder);

  public abstract Integer delProById(Long paramLong);

  public abstract Integer updatePro(Order paramOrder);

  public abstract Order getSinglePro(CustomerOrderRequest paramCustomerOrderRequest);
}