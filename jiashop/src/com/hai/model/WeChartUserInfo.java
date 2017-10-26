package com.hai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wechartuser")
public class WeChartUserInfo
{
  private int id;
  private String openId;
  private int subscribe;
  private String subscribeTime;
  private String nickname;
  private int sex;
  private String country;
  private String province;
  private String city;
  private String language;
  private String headImgUrl;
  private String appid;

  @Id
  @Column(name="openid", unique=true, nullable=false)
  public String getOpenId()
  {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
  @Column(name="subscribe")
  public int getSubscribe() {
    return this.subscribe;
  }

  public void setSubscribe(int subscribe) {
    this.subscribe = subscribe;
  }
  @Column(name="subscribetime")
  public String getSubscribeTime() {
    return this.subscribeTime;
  }

  public void setSubscribeTime(String subscribeTime) {
    this.subscribeTime = subscribeTime;
  }
  @Column(name="nickname")
  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  @Column(name="sex")
  public int getSex() {
    return this.sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  @Column(name="country")
  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  @Column(name="province")
  public String getProvince() {
    return this.province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
  @Column(name="city")
  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }
  @Column(name="language")
  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
  @Column(name="headimgurl")
  public String getHeadImgUrl() {
    return this.headImgUrl;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }

  @Column(name="appid")
  public String getAppid() {
    return this.appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }
}