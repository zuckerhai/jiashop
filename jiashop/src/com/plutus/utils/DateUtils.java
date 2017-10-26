package com.plutus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
  public static String formatDateToString(Date date, String format)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }
}