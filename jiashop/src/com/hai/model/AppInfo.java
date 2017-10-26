package com.hai.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appinfo", catalog="hjiatool")
public class AppInfo
  implements Serializable
{
  private Integer id;
  private SysUser sysUser;
  private Integer apptype;
  private String appname;
  private Date creatime;
  private Integer isactiive;
  private Set<WxStruct> wxStructs = new HashSet(0);

  public AppInfo()
  {
  }

  public AppInfo(Integer id)
  {
    this.id = id;
  }

  public AppInfo(Integer id, SysUser sysUser, Integer apptype, String appname, Date creatime, Integer isactiive, Set<WxStruct> wxStructs)
  {
    this.id = id;
    this.sysUser = sysUser;
    this.apptype = apptype;
    this.appname = appname;
    this.creatime = creatime;
    this.isactiive = isactiive;
    this.wxStructs = wxStructs;
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
  @JoinColumn(name="userid")
  public SysUser getSysUser() {
    return this.sysUser;
  }

  public void setSysUser(SysUser sysUser) {
    this.sysUser = sysUser;
  }

  @Column(name="apptype")
  public Integer getApptype()
  {
    return this.apptype;
  }

  public void setApptype(Integer apptype) {
    this.apptype = apptype;
  }

  @Column(name="appname")
  public String getAppname()
  {
    return this.appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }
  @Temporal(TemporalType.DATE)
  @Column(name="creatime", length=10)
  public Date getCreatime() {
    return this.creatime;
  }

  public void setCreatime(Date creatime) {
    this.creatime = creatime;
  }

  @Column(name="isactiive")
  public Integer getIsactiive()
  {
    return this.isactiive;
  }

  public void setIsactiive(Integer isactiive) {
    this.isactiive = isactiive;
  }

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="appInfo")
  public Set<WxStruct> getWxStructs() {
    return this.wxStructs;
  }

  public void setWxStructs(Set<WxStruct> wxStructs) {
    this.wxStructs = wxStructs;
  }
}