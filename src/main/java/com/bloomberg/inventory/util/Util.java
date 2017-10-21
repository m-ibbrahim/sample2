package com.bloomberg.inventory.util;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Util
{

  String dataDir = "C:/emmdiim/sample2/src/dist/data";
  String dataFileName = "deal.csv";

  private static final long ONE_HOUR = 60 * 60 * 1000l;
  private static final long ONE_MINUTE = 60 * 1000l;
  private static final long ONE_SECOND = 1000l;

  public List<String[]> readCsv() throws Exception
  {
    List<String[]> rows = parseDataFile();
    return rows;
  }

  private List<String[]> parseDataFile()
  {
    List<String[]> processedInput = new ArrayList<String[]>();
    File dataFile = getDataFile();

    if (dataFile.isFile() && dataFile.getName().endsWith(".csv"))
    {
      try
      {
        List<String> rawInput = loadJobControlFile(dataFile);

        // Ignore the lines which start with #
        processedInput = rawInput.stream().filter(l -> !l.startsWith("#")).map(a -> a.split(","))
            .filter(i -> !StringUtils.isBlank(i[0]) && !StringUtils.isBlank(i[1]) && !StringUtils.isBlank(i[2])).collect(toList());
        // System.out.println(processedInput);
      }
      catch (Throwable t)
      {
        // log.error(" * Error processing job control file", t);
      }
    }
    else
    {
      // log.error(" * Invalid job control file - {} . Check if it is a
      // file/folder and it ends with .conf extension", ctlFile.getName());
    }
    // log.debug(" - Jobs configuration file read successfully");
    return processedInput;
  }

  private File getDataFile()
  {
    String absJobFileName = dataDir + File.separator + dataFileName;
    return Paths.get(absJobFileName).toFile();
  }

  private List<String> loadJobControlFile(File file) throws Exception
  {
    return Files.lines(Paths.get(file.getAbsolutePath())).collect(toList());
  }

  public static String toFriendlyDuration(long totalTimeInMS)
  {
    StringBuilder sb = new StringBuilder();

    long hours = 0;
    long minutes = 0;
    long seconds = 0;

    hours = totalTimeInMS / ONE_HOUR;

    if (hours > 0)
    {
      sb.append("H: ").append(hours).append(", ");
      totalTimeInMS = totalTimeInMS - (hours * ONE_HOUR);
    }

    minutes = totalTimeInMS / ONE_MINUTE;

    if (minutes > 0)
    {
      sb.append("M: ").append(minutes).append(", ");
      totalTimeInMS = totalTimeInMS - (minutes * ONE_MINUTE);
    }

    seconds = totalTimeInMS / ONE_SECOND;

    if (seconds > 0)
    {
      sb.append("S: ").append(seconds).append(", ");
      totalTimeInMS = totalTimeInMS - (seconds * ONE_SECOND);
    }

    if (totalTimeInMS > 0)
    {
      sb.append("MS: ").append(totalTimeInMS);
    }

    return sb.toString();
  }

  public static void main(String args[])
  {
    System.out.println("Hello world..");
    Util obj = new Util();
    try
    {
      List<String[]> rows = obj.readCsv();
      for (String[] row : rows)
      {
        System.out.println("  - " + row[0] + row[1] + row[2] + row[3]);
      }
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
