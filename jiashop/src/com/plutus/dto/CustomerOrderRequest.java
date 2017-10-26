package com.plutus.dto;

public class CustomerOrderRequest
{
  private Integer limit;
  private Integer offset;
  private String order;
  private String search;
  private Long customerId;
  private String protype;

  public Integer getLimit()
  {
    return this.limit;
  }

  public Integer getOffset() {
    return this.offset;
  }

  public String getOrder() {
    return this.order;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public String getSearch() {
    return this.search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public String getProtype() {
    return this.protype;
  }

  public void setProtype(String protype) {
    this.protype = protype;
  }
}