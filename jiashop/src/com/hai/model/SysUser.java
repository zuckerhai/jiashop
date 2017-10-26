package com.hai.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sysuser", catalog="hjiatool")
public class SysUser
  implements Serializable
{
  private Long id;
  private String username;
  private String password;
  private String email;
  private Date joindate;
  private String phonenum;
  private Set<AppInfo> appInfos = new HashSet(0);
  private Set<SysContent> sysContents = new HashSet(0);

  public SysUser()
  {
  }

  public SysUser(String username, String password, String email, Date joindate, String phonenum, Set<AppInfo> appInfos, Set<SysContent> sysContents)
  {
    this.username = username;
    this.password = password;
    this.email = email;
    this.joindate = joindate;
    this.phonenum = phonenum;
    this.appInfos = appInfos;
    this.sysContents = sysContents;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name="username", length=100)
  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name="password", length=100)
  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name="email", length=100)
  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  @Temporal(TemporalType.DATE)
  @Column(name="joindate", length=10)
  public Date getJoindate() {
    return this.joindate;
  }

  public void setJoindate(Date joindate) {
    this.joindate = joindate;
  }

  @Column(name="phonenum")
  public String getPhonenum()
  {
    return this.phonenum;
  }

  public void setPhonenum(String phonenum) {
    this.phonenum = phonenum;
  }

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="sysUser")
  public Set<AppInfo> getAppInfos() {
    return this.appInfos;
  }

  public void setAppInfos(Set<AppInfo> appInfos) {
    this.appInfos = appInfos;
  }

  @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="sysUser")
  public Set<SysContent> getSysContents() {
    return this.sysContents;
  }

  public void setSysContents(Set<SysContent> sysContents) {
    this.sysContents = sysContents;
  }
}