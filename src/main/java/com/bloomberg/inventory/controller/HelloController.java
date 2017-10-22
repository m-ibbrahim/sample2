package com.bloomberg.inventory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller
{

  protected final Log logger = LogFactory.getLog(getClass());

  @Override
  public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
      throws Exception
  {
    logger.info("Returning hello view");

    return new ModelAndView("index.html");
  }

}
