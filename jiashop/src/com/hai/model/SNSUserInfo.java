package com.hai.model;

import java.util.List;

public class SNSUserInfo
{
  private String openid;
  private String nickname;
  private String sex;
  private String province;
  private String city;
  private String country;
  private String headimgurl;
  private List priList;

  public String getOpenid()
  {
    return this.openid;
  }
  public void setOpenid(String openid) {
    this.openid = openid;
  }
  public String getNickname() {
    return this.nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  public String getSex() {
    return this.sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getProvince() {
    return this.province;
  }
  public void setProvince(String province) {
    this.province = province;
  }
  public String getCity() {
    return this.city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getCountry() {
    return this.country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getHeadimgurl() {
    return this.headimgurl;
  }
  public void setHeadimgurl(String headimgurl) {
    this.headimgurl = headimgurl;
  }
  public List getPriList() {
    return this.priList;
  }
  public void setPriList(List priList) {
    this.priList = priList;
  }
}