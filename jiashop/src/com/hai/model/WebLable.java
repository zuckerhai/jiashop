package com.hai.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weblable", catalog="hjiatool")
public class WebLable
  implements Serializable
{
  private Integer id;
  private String enname;
  private String cnname;
  private String url;
  private String structs;

  public WebLable()
  {
  }

  public WebLable(String enname, String cnname, String url, String structs)
  {
    this.enname = enname;
    this.cnname = cnname;
    this.url = url;
    this.structs = structs;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name="enname")
  public String getEnname()
  {
    return this.enname;
  }

  public void setEnname(String enname) {
    this.enname = enname;
  }

  @Column(name="cnname")
  public String getCnname()
  {
    return this.cnname;
  }

  public void setCnname(String cnname) {
    this.cnname = cnname;
  }

  @Column(name="url")
  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Column(name="structs")
  public String getStructs()
  {
    return this.structs;
  }

  public void setStructs(String structs) {
    this.structs = structs;
  }
}