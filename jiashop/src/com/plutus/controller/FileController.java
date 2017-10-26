package com.plutus.controller;

import com.hai.common.ImageUtil;
import com.plutus.dto.Result;
import com.plutus.entity.MyFile;
import com.plutus.service.FileService;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/file"})
public class FileController
{

  @Autowired
  private FileService fileService;

  @RequestMapping({"/upload"})
  @ResponseBody
  public Result uploadFile(HttpServletRequest request)
    throws Exception
  {
    List insertFileIds = new ArrayList();

    String basePath = "E:\\files\\";
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    if (ServletFileUpload.isMultipartContent(request)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      factory.setRepository(file);
      factory.setSizeThreshold(1024000);
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setHeaderEncoding("UTF-8");
      upload.setSizeMax(10000000L);
      List<FileItem> fileItems = new ArrayList();
      try {
        fileItems = upload.parseRequest(request);
      } catch (FileUploadException e1) {
        System.out.println("文件上传发生错误" + e1.getMessage());
      }
      for (FileItem item: fileItems) {
        if (!item.isFormField())
        {
          String fileName = item.getName();

          String fileEnd = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

          String uuid = UUID.randomUUID().toString();

          StringBuffer sbRealPath = new StringBuffer();
          sbRealPath.append(basePath).append(uuid).append(".").append(fileEnd);
          StringBuffer showPath = new StringBuffer("files\\").append(uuid).append(".").append(fileEnd);

          File thisFile = new File(sbRealPath.toString());

          item.write(thisFile);
          ImageUtil.compressImage(thisFile, fileEnd, 800);

          MyFile myFile = new MyFile();
          myFile.setFileName(fileName);
          myFile.setPath(showPath.toString());
          myFile.setFileType(fileEnd.toLowerCase());
          this.fileService.insertFile(myFile);
          insertFileIds.add(myFile.getId());
        }
      }
    }
    return new Result(Integer.valueOf(200), insertFileIds, "success");
  }
  @RequestMapping({"/query"})
  @ResponseBody
  public Result queryFiles(String fileStr) {
    String[] fileStrs = fileStr.split(",");
    List files = new ArrayList();
    for (int i = 0; i < fileStrs.length; i++) {
      MyFile file = this.fileService.findById(Long.valueOf(Long.parseLong(fileStrs[i])));
      files.add(file);
    }
    return new Result(Integer.valueOf(200), files, "success");
  }
}