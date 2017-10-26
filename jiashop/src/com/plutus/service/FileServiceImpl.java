package com.plutus.service;

import com.plutus.dao.FileDao;
import com.plutus.entity.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl
  implements FileService
{

  @Autowired
  private FileDao fileDao;

  public Integer insertFile(MyFile file)
  {
    return this.fileDao.insertFile(file);
  }

  public MyFile findById(Long id)
  {
    return this.fileDao.findById(id);
  }

  public Integer deleteById(Long id)
  {
    return this.fileDao.deleteById(id);
  }
}