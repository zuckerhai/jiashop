package com.plutus.controller;

import com.plutus.dao.OrderDao;
import com.plutus.dto.CustomerOrderRequest;
import com.plutus.dto.Result;
import com.plutus.dto.TableResponse;
import com.plutus.entity.MyFile;
import com.plutus.entity.Order;
import com.plutus.service.FileService;
import com.plutus.service.OrderService;
import com.plutus.utils.DateUtils;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/order"})
public class OrderController
{
  private static final String FORMAT_DATE = "yyyy-MM-dd";
  private static final String FORMAT_DATE_TO_HOUR = "yyyy-MM-dd hh:mm:ss";

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private FileService fileService;

  @RequestMapping({""})
  public String orderPage()
  {
    return "order";
  }

  @RequestMapping({"/prolist"})
  @ResponseBody
  public TableResponse queryCustomerOrderTable(@RequestBody CustomerOrderRequest request)
  {
    if (request.getSearch() == null) {
      request.setSearch("");
    }
    Integer count = this.orderService.findCountByCustomerId(request);
    List orders = this.orderService
      .findAllWithCustomerPageableByCustomerId(request);
    TableResponse response = new TableResponse();
    response.setTotal(count);
    response.setRows(orders);
    return response;
  }

  @RequestMapping({"/getproinfo"})
  @ResponseBody
  public Result getproinfo(@RequestBody CustomerOrderRequest request)
  {
    Order retObj = this.orderService.getSinglePro(request);
    if (retObj == null) {
      return new Result(Integer.valueOf(500), "FAIL", "Add order record failed !");
    }
    return new Result(Integer.valueOf(200), retObj, "success");
  }
  @RequestMapping({"/addpro"})
  @ResponseBody
  public Result addOrder(@RequestBody Order order) {
    order.setAddtime(DateUtils.formatDateToString(new Date(), 
      "yyyy-MM-dd HH:mm:ss"));
    if ((order.getFiles() != null) && (order.getFiles().length() > 0)) {
      String fileid = order.getFiles().split(",")[0];
      order.setFile(this.fileService.findById(Long.valueOf(Long.parseLong(fileid))).getPath());
    }
    Integer ins = this.orderService.addOrder(order);
    if ((ins == null) || (ins.intValue() <= 0)) {
      return new Result(Integer.valueOf(500), "FAIL", "Add order record failed !");
    }
    return new Result(Integer.valueOf(200), "success");
  }

  @RequestMapping({"delete"})
  @ResponseBody
  public Result deleteOrder(@RequestBody Order order, HttpServletRequest request) {
    Integer ins = this.orderDao.delProById(order.getProid());
    String fileStr = order.getFiles();

    if (!"".equals(fileStr)) {
      String[] fileStrs = fileStr.split(",");
      for (int i = 0; i < fileStrs.length; i++) {
        MyFile file = this.fileService.findById(Long.valueOf(Long.parseLong(fileStrs[i])));
        String basePath = "E:\\";
        File delfile = new File(basePath + file.getPath());
        delfile.delete();
        this.fileService.deleteById(file.getId());
      }

    }

    if ((ins == null) || (ins.intValue() <= 0)) {
      return new Result(Integer.valueOf(500), "FAIL", "Add order record failed !");
    }
    return new Result(Integer.valueOf(200), "success");
  }
  @RequestMapping({"update"})
  @ResponseBody
  public Result updateOrder(@RequestBody Order order) {
    order.setAddtime(DateUtils.formatDateToString(new Date(), 
      "yyyy-MM-dd HH:mm:ss"));
    Integer ins = this.orderDao.updatePro(order);
    if ((ins == null) || (ins.intValue() <= 0)) {
      return new Result(Integer.valueOf(500), "FAIL", "Add order record failed !");
    }
    return new Result(Integer.valueOf(200), "success");
  }
}