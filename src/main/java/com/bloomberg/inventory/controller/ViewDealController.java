package com.bloomberg.inventory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bloomberg.inventory.config.AppConfig;
import com.bloomberg.inventory.service.DealService;
import com.bloomberg.inventory.service.InvalidDealService;

/**
 * 
 *
 */
public class ViewDealController implements Controller
{

  /**
   * 
   */
  private static final Logger logger = Logger.getLogger(ViewDealController.class);

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet. http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
  {
    logger.info(" - Enter: ViewDealController");

    // Create a context:
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Create an object of Service class:
    DealService dealService = context.getBean(DealService.class);

    // Create an object of Service class:
    InvalidDealService invalidDealService = context.getBean(InvalidDealService.class);
    
    

    return new ModelAndView("/jsp/viewDeals.jsp");
  }

}
