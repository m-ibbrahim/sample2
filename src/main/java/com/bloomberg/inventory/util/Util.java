package com.bloomberg.inventory.util;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * This is a utility class for the application that contains common methods to be used across.
 */
public class Util
{

  private static final Logger logger = Logger.getLogger(Util.class);

  // TODO: Read the fileName from the jsp page. Currently unable to get the file name, hence hard coded.
  // TODO: Remove these attributes once we get from the form. For now, copy the deal.csv to the C:/ to make it work.
  String dataDir = "C:/";
  String dataFileName = "deal_100_Records.csv";

  private static final long ONE_HOUR = 60 * 60 * 1000l;
  private static final long ONE_MINUTE = 60 * 1000l;
  private static final long ONE_SECOND = 1000l;

  /**
   * This is a utility method to parse the file line by line.
   * 
   * @return
   * @throws Exception
   */
  public List<List<String[]>> readCsv() throws Exception
  {
    return parseDataFile();
  }

  /**
   * This is a method to parse the csv file. It makes use of the Jdk 8 streams and lambda expressions to read the file.<br>
   * 
   * Business rules: <br>
   * 1. Ignore the lines starting with #
   * 
   * @return
   */
  private List<List<String[]>> parseDataFile()
  {
    List<String[]> validInputs = new ArrayList<String[]>();
    List<String[]> invalidInputs = new ArrayList<String[]>();
    List<List<String[]>> processedInput = new ArrayList();

    File dataFile = getDataFile();

    if (dataFile.isFile() && dataFile.getName().endsWith(".csv"))
    {
      try
      {
        List<String> rawInput = loadFile(dataFile);

        // Ignore records:
        // 1. Which start with #,
        // 2. DEAL_UNIQUE_ID, FROM_CURRENCY_ISO_CODE, TO_CURRENCY_ISO_CODE, DEAL_TIMESTAMP, DEAL_AMOUNT is blank
        // 3. FROM_CURRENCY_ISO_CODE, TO_CURRENCY_ISO_CODE is less than 3 characters
        validInputs = rawInput.stream().filter(l -> !l.startsWith("#")).map(a -> a.split(","))
            .filter(i -> !StringUtils.isBlank(i[0]) && !StringUtils.isBlank(i[1]) && !StringUtils.isBlank(i[2]) && !StringUtils.isBlank(i[3]) && !StringUtils.isBlank(i[4])).collect(toList());

        invalidInputs = rawInput.stream().filter(l -> !l.startsWith("#")).map(a -> a.split(",")).filter(i -> StringUtils.isBlank(i[0]) || StringUtils.isBlank(i[1]) || StringUtils.isBlank(i[2])
            || StringUtils.isBlank(i[3]) || StringUtils.isBlank(i[4]) || i[2].length() != 3 || i[3].length() != 3).collect(toList());

      }
      catch (Throwable t)
      {
        logger.error(" * Error processing job control file", t);
      }
    }
    else
    {
      logger.error(" * Invalid job control file - {} . Check if it is a file/folder and it ends with .conf extension");
    }
    logger.debug(" - Jobs configuration file read successfully");
    processedInput.add(validInputs);
    processedInput.add(invalidInputs);
    return processedInput;
  }

  /**
   * Get the name of the data file.
   * 
   * @return
   */
  private File getDataFile()
  {
    String absJobFileName = dataDir + File.separator + dataFileName;
    return Paths.get(absJobFileName).toFile();
  }

  /**
   * This is a utility method to load the csv file.
   * 
   * @param file
   * @return
   * @throws Exception
   */
  private List<String> loadFile(File file) throws Exception
  {
    return Files.lines(Paths.get(file.getAbsolutePath())).collect(toList());
  }

  /**
   * This is a utility method to convert the time in ms to readable format.
   * 
   * @param totalTimeInMS
   * @return
   */
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
}
