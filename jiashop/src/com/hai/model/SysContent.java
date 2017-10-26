package com.hai.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="syscontent", catalog="hjiatool")
public class SysContent
  implements Serializable
{
  private Long id;
  private SysUser sysUser;
  private String img;
  private String content;
  private Date date;
  private String col1;

  public SysContent()
  {
  }

  public SysContent(SysUser sysUser)
  {
    this.sysUser = sysUser;
  }

  public SysContent(SysUser sysUser, String img, String content, Date date, String col1)
  {
    this.sysUser = sysUser;
    this.img = img;
    this.content = content;
    this.date = date;
    this.col1 = col1;
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
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="userid", nullable=false)
  public SysUser getSysUser() {
    return this.sysUser;
  }

  public void setSysUser(SysUser sysUser) {
    this.sysUser = sysUser;
  }

  @Column(name="img", length=100)
  public String getImg()
  {
    return this.img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  @Column(name="content")
  public String getContent()
  {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  @Temporal(TemporalType.DATE)
  @Column(name="date", length=10)
  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Column(name="col1")
  public String getCol1()
  {
    return this.col1;
  }

  public void setCol1(String col1) {
    this.col1 = col1;
  }
}