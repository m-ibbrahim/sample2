package com.bloomberg.inventory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 *
 */
public class ViewDealController implements Controller
{

  /**
   * 
   */
  protected final Log logger = LogFactory.getLog(getClass());

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.
   * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
  {
    logger.info(" - Enter: ViewDealController");

    return new ModelAndView("/jsp/addDeal.jsp");
  }

}
