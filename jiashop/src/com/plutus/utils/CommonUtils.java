package com.plutus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils
{
  public static final String ORDER_CODE_HEAD_NORMAL = "N";

  public static String genOrderCode(String codeHead)
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
    String code = codeHead + sdf.format(date);
    return code;
  }
}