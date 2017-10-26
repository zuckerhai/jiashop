package com.hai.model;

public class TbRspStruct
{
  private static final long serialVersionUID = 1L;
  private int total_results;
  private boolean has_next;
  private Trades trades;

  public int getTotal_results()
  {
    return this.total_results;
  }
  public boolean isHas_next() {
    return this.has_next;
  }
  public Trades getTrades() {
    return this.trades;
  }
  public void setTotal_results(int total_results) {
    this.total_results = total_results;
  }
  public void setHas_next(boolean has_next) {
    this.has_next = has_next;
  }
  public void setTrades(Trades trades) {
    this.trades = trades;
  }
}