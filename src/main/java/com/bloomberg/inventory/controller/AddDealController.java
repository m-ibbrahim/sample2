package com.bloomberg.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bloomberg.inventory.config.AppConfig;
import com.bloomberg.inventory.form.DealForm;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.service.DealService;
import com.bloomberg.inventory.util.Util;

/**
 * This is a Controller class Add the deals. The control reaches this class when the user selects the data file and clicks on the Upload button. <br>
 * 
 * 
 * This controller class:<br>
 * 
 * 1. Verifies if the format of the file is correct. <br>
 * 2. Verifies the valid record and adds it to the database. <br>
 * 3. Navigates back to the view deals page.
 */
public class AddDealController implements Controller
{

  /**
   * Instantiate logger:
   */
  private static final Logger logger = Logger.getLogger(AddDealController.class);

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet. http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
  {
    logger.info("   - Enter: AddDealController");

    Util util = new Util(); // TODO: To instantiated using @Autowoired

    // List of valid deals to the written to the database:
    List<Deal> deals = new ArrayList<Deal>();

    // Create a context:
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Create an object of Service class:
    DealService dealService = context.getBean(DealService.class);

    // Get the upload filename:
    String dataFileName = getUploadFileName();

    // Data loading starts from here:
    try
    {
      long start = System.currentTimeMillis();
      logger.debug("    ------------------------------------------------------------------");
      logger.debug("    DATA LOADING IS STARTING NOW");
      logger.debug("    ------------------------------------------------------------------");
      logger.debug("    - Load the data from " + dataFileName);

      // Read the CSV data file:
      List<List<String[]>> rows = util.readCsv();

      // Get the valid deals from the CSV file:
      List<String[]> validDeals = rows.get(0);

      // Get the invalid deals from the CSV file:
      List<String[]> invalidDeals = rows.get(1);

      // Removing the deals to avoid integrity exception while adding the deals.
      removeDeals(validDeals, dealService);// TODO: Unable to get the fileName from the multiform(AddDeal.jsp).

      // Iterate through the rows from the csv file and create a Deal object
      for (String[] row : validDeals)
      {
        logger.debug(" - " + row[0] + row[1] + row[2] + row[3]);
        deals.add(new Deal(row[0], row[1], row[2], row[3], row[4], dataFileName));
      }

      // Add the deals to the database in batches
      dealService.add(deals);

      long end = System.currentTimeMillis();
      logger.debug("    ------------------------------------------------------------------");
      logger.debug("    DATA LOADING ENDING NOW");
      logger.debug("    ------------------------------------------------------------------");
      String totalTime = Util.toFriendlyDuration(end - start);
      logger.info("   - Time taken to read, parse the CSV file: " + totalTime);
    }
    catch (Exception e)
    {
      logger.error(" *  Exception while adding the deals - " + e.getMessage());
      e.printStackTrace();
    }

    // Close the context
    context.close();

    logger.info("   - Exit: AddDealController");
    return new ModelAndView("jsp/addDeal.jsp");
  }

  /**
   * This is a temporary method to delete the deals from the database(to avoid integrity exception while inserting the records.<br>
   * 
   * TODO: Remove this method once we are able to get the fileName from the multirecord type(AddDeal.jsp).
   * 
   * @param rows
   * @param dealService
   */
  private void removeDeals(List<String[]> rows, DealService dealService)
  {
    try
    {
      for (String[] row : rows)
      {
        logger.debug(" - Removing deal:" + row[0]);
        dealService.remove(new Deal(row[0], row[1], row[2], row[3], row[4], null));
      }
    }
    catch (Exception e)
    {
      logger.error(" *  Exception while removing the deals - " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * This method returns the name of the uploaded file so that it cannot be processed again. <br>
   * TODO: Unable to get the fileName from the jsp page(AddDeal.jsp). Hence the location of the file is hardcoded in Util.java.
   * 
   * @return
   */
  private String getUploadFileName()
  {
    // TODO: Get the name of the file from the AddDeal.jsp page.

    // MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) arg0;
    // CommonsMultipartFile multipartFile = null;
    // Iterator<String> iterator = multipartRequest.getFileNames();
    // while (iterator.hasNext())
    // {
    // String key = (String) iterator.next();
    // // create multipartFile array if you upload multiple files
    // multipartFile = (CommonsMultipartFile) multipartRequest.getFile(key);
    // logger.debug( "======= " + multipartFile.getOriginalFilename()); // get filename on client's machine
    // logger.debug(multipartFile.getContentType()); // get content type, you can recognize which kind of file is, pdf or image or doc etc
    // logger.debug(multipartFile.getSize()); // get file size in bytes
    // }
    DealForm form = new DealForm();
    return form.getFileName();
  }
}
