package com.plutus.entity;

import java.io.Serializable;

public class MyFile
  implements Serializable
{
  private Long id;
  private String fileName;
  private String path;
  private String fileType;

  public void setFileType(String fileType)
  {
    this.fileType = fileType;
  }

  public String getFileType()
  {
    return this.fileType;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Long getId()
  {
    return this.id;
  }

  public String getFileName() {
    return this.fileName;
  }

  public String getPath() {
    return this.path;
  }
}