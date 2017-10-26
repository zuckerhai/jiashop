package com.plutus.dto;

public class TableRequest
{
  private Integer limit;
  private Integer offset;
  private String order;
  private String search;

  public void setSearch(String search)
  {
    this.search = search;
  }

  public String getSearch()
  {
    return this.search;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public void setOrder(String order) {
    this.order = order;
  }

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
}