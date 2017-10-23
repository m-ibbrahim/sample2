package com.bloomberg.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bloomberg.inventory.config.AppConfig;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.service.DealService;
import com.bloomberg.inventory.util.Util;

public class HelloController implements Controller
{

  protected final Log logger = LogFactory.getLog(getClass());

  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
  {
    logger.info("Returning hello view");

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    Util util = new Util();
    DealService dealService = context.getBean(DealService.class);
    try
    {
      List<String[]> rows = util.readCsv();
      for (String[] row : rows)
      {
        // logger.debug(" - " + row[0] + row[1] + row[2] + row[3]);
        dealService.remove(new Deal(row[0], row[1], row[2], row[3], row[4], null));
      }
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try
    {
      long start = System.currentTimeMillis();
      // logger.debug("------------------------------------------------------------------");
      // logger.debug(" DATA LOADING IS STARTING NOW");
      // logger.debug("------------------------------------------------------------------");
      // logger.debug(" - Extract-Load the data from " +
      // this.dataFileName);

      List<String[]> rows = util.readCsv();
      for (String[] row : rows)
      {
        // System.out.println(" - " + row[0] + row[1] + row[2] + row[3]);
        dealService.add(new Deal(row[0], row[1], row[2], row[3], row[4], null));
      }

      long end = System.currentTimeMillis();
      // logger.debug("------------------------------------------------------------------");
      // logger.debug(" DATA LOADING ENDING NOW");
      // logger.debug("------------------------------------------------------------------");
      String totalTime = Util.toFriendlyDuration(end - start);
      logger.info("Time taken to read, parse the CSV file: " + totalTime);
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    context.close();
    return new ModelAndView("index.html");
  }

}
