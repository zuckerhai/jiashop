package com.hai.common;

import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import javax.imageio.ImageIO;

public class ImageUtil
{
  public static final int SCALE = 10;
  public static final int WIDTH = 400;
  public static final int HEIGHT = 400;
  public static final String GIF = "gif";
  public static final String PNG = "png";

  public static void main(String[] args)
    throws Exception
  {
    File file = new File("C:\\Users\\hai.jiang\\Desktop\\c");
    String[] fileName = file.list();
    for (int i = 0; i < fileName.length; i++) {
      System.out.println(fileName[i]);
      File tmpFile = new File("C:\\Users\\hai.jiang\\Desktop\\c\\" + 
        fileName[i]);
      compressImage(tmpFile, 
        fileName[i].substring(fileName[i].lastIndexOf(".") + 1), 
        800);
    }
  }

  public static void getThumbnail(File src, String fileSuffix, int _width, int _height)
    throws Exception
  {
    try
    {
      BufferedImage bi2 = ImageIO.read(src);

      int width = bi2.getWidth(null);
      int height = bi2.getHeight(null);

      int newWidth = 0;
      int newHeight = 0;
      if ((width <= _width) && (height <= _height)) {
        _width = width;
        _height = height;
      }

      if (width / _width > height / _height) {
        newWidth = _width;
        newHeight = _width * height / width;
      } else {
        newHeight = _height;
        newWidth = _height * width / height;
      }

      ResampleOp rsop = new ResampleOp(
        DimensionConstrain.createMaxDimension(newWidth, newHeight, 
        true));
      BufferedImage to = rsop.filter(bi2, null);
      ImageIO.write(to, fileSuffix, src);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  public static void compressImage(File src, String fileSuffix, int _width, int _height)
    throws Exception
  {
    InputStream is = null;
    try {
      BufferedImage bi2 = ImageIO.read(src);

      int width = bi2.getWidth(null);
      int height = bi2.getHeight(null);

      int newWidth = 0;
      int newHeight = 0;
      if ((width <= _width) && (height <= _height)) {
        _width = width;
        _height = height;
      }

      if (width / _width > height / _height) {
        newWidth = _width;
        newHeight = _width * height / width;
      } else {
        newHeight = _height;
        newWidth = _height * width / height;
      }

      ResampleOp rsop = new ResampleOp(
        DimensionConstrain.createMaxDimension(newWidth, newHeight, 
        true));
      BufferedImage to = rsop.filter(bi2, null);
      ImageIO.write(to, fileSuffix, src);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  public static void compressImage(File src, String fileSuffix, int _width)
    throws Exception
  {
    try
    {
      BufferedImage bi2 = ImageIO.read(src);

      int width = bi2.getWidth(null);
      int height = bi2.getHeight(null);

      int newWidth = 0;
      int newHeight = 0;
      if (width < _width) {
        _width = width;
      }
      newWidth = _width;

      newHeight = height * _width / width;

      ResampleOp rsop = new ResampleOp(
        DimensionConstrain.createMaxDimension(newWidth, newHeight, 
        false));
      BufferedImage to = rsop.filter(bi2, null);
      ImageIO.write(to, fileSuffix, src);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
  }
}