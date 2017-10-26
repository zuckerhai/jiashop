package com.plutus.service;

import com.plutus.dao.OrderDao;
import com.plutus.dto.CustomerOrderRequest;
import com.plutus.entity.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl
  implements OrderService
{

  @Autowired(required=false)
  private OrderDao orderDao;

  public List<Order> findAllWithCustomerPageableByCustomerId(CustomerOrderRequest request)
  {
    return this.orderDao.findAllWithCustomerPageableByCustomerId(request);
  }

  public Integer findCountByCustomerId(CustomerOrderRequest request)
  {
    return this.orderDao.findCountByCustomerId(request);
  }

  public Integer addOrder(Order order)
  {
    return this.orderDao.addOrder(order);
  }

  public Order getSinglePro(CustomerOrderRequest request)
  {
    return this.orderDao.getSinglePro(request);
  }
}