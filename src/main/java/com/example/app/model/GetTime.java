package com.example.app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetTime {

  public String getTimeStamp(){

    Calendar instance = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss:ms");
    return sdf.format(instance.getTime());
  }

}
