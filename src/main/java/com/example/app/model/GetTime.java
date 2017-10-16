package com.example.app.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class for creating timestamp. Used to append timestamp to folders.
 */
public class GetTime {

  /**
   * Method for creating timestamp.
   *
   * @return String formatted timestamp.
   */
  public String getTimeStamp() {
    Calendar instance = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss:ms");
    return sdf.format(instance.getTime());
  }

}
