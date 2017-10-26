package com.hai.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wxstruct", catalog="hjiatool")
public class WxStruct
  implements Serializable
{
  private Integer id;
  private AppInfo appInfo;
  private String wxappid;
  private String wxappsecret;
  private String token;
  private String wxjs;
  private String wxcol1;
  private String wxcol2;

  public WxStruct()
  {
  }

  public WxStruct(Integer id)
  {
    this.id = id;
  }

  public WxStruct(Integer id, AppInfo appInfo, String wxappid, String wxappsecret, String token, String wxjs, String wxcol1, String wxcol2)
  {
    this.id = id;
    this.appInfo = appInfo;
    this.wxappid = wxappid;
    this.wxappsecret = wxappsecret;
    this.token = token;
    this.wxjs = wxjs;
    this.wxcol1 = wxcol1;
    this.wxcol2 = wxcol2;
  }

  @Id
  @Column(name="id", unique=true, nullable=false)
  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="appid")
  public AppInfo getAppInfo() {
    return this.appInfo;
  }

  public void setAppInfo(AppInfo appInfo) {
    this.appInfo = appInfo;
  }

  @Column(name="wxappid")
  public String getWxappid()
  {
    return this.wxappid;
  }

  public void setWxappid(String wxappid) {
    this.wxappid = wxappid;
  }

  @Column(name="wxappsecret")
  public String getWxappsecret()
  {
    return this.wxappsecret;
  }

  public void setWxappsecret(String wxappsecret) {
    this.wxappsecret = wxappsecret;
  }

  @Column(name="token")
  public String getToken()
  {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Column(name="wxjs")
  public String getWxjs()
  {
    return this.wxjs;
  }

  public void setWxjs(String wxjs) {
    this.wxjs = wxjs;
  }

  @Column(name="wxcol1")
  public String getWxcol1()
  {
    return this.wxcol1;
  }

  public void setWxcol1(String wxcol1) {
    this.wxcol1 = wxcol1;
  }

  @Column(name="wxcol2")
  public String getWxcol2()
  {
    return this.wxcol2;
  }

  public void setWxcol2(String wxcol2) {
    this.wxcol2 = wxcol2;
  }
}