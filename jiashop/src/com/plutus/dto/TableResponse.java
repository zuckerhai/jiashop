package com.plutus.dto;

public class TableResponse
{
  private Integer total;
  private Object rows;

  public void setTotal(Integer total)
  {
    this.total = total;
  }

  public void setRows(Object rows) {
    this.rows = rows;
  }

  public Integer getTotal()
  {
    return this.total;
  }

  public Object getRows() {
    return this.rows;
  }
}