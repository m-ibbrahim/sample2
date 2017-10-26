package com.bloomberg.inventory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * This is a Controller class to handle the login operation. The LoginController verifies the user credentials and navigates to the home page of the
 * application.
 *
 */
public class LoginController implements Controller
{

  /**
   * 
   */
  private static final Logger logger = Logger.getLogger(LoginController.class);

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet. http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
  {
    logger.info(" - Inside LoginController. Successful login. Navigating to home page.");
    return new ModelAndView("/jsp/addDeal.jsp");
  }
}
