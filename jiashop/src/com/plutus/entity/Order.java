package com.plutus.entity;

import java.io.Serializable;

public class Order
  implements Serializable
{
  private Long proid;
  private String proname;
  private String protype;
  private String prolab;
  private String prodescrip;
  private String addtime;
  private String files;
  private String tags;
  private String file;

  public Long getProid()
  {
    return this.proid;
  }

  public void setProid(Long proid) {
    this.proid = proid;
  }

  public String getProname() {
    return this.proname;
  }

  public void setProname(String proname) {
    this.proname = proname;
  }

  public String getProtype() {
    return this.protype;
  }

  public void setProtype(String protype) {
    this.protype = protype;
  }

  public String getProlab() {
    return this.prolab;
  }

  public void setProlab(String prolab) {
    this.prolab = prolab;
  }

  public String getProdescrip() {
    return this.prodescrip;
  }

  public void setProdescrip(String prodescrip) {
    this.prodescrip = prodescrip;
  }

  public String getAddtime() {
    return this.addtime;
  }

  public void setAddtime(String addtime) {
    this.addtime = addtime;
  }

  public String getFiles() {
    return this.files;
  }

  public void setFiles(String files) {
    this.files = files;
  }

  public String getTags() {
    return this.tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getFile() {
    return this.file;
  }

  public void setFile(String file) {
    this.file = file;
  }
}