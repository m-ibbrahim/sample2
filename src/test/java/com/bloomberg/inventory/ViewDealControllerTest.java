package com.bloomberg.inventory;

import org.springframework.web.servlet.ModelAndView;

import com.bloomberg.inventory.controller.ViewDealController;

import junit.framework.TestCase;

public class ViewDealControllerTest extends TestCase
{
  public void testHandleRequestView() throws Exception
  {
    ViewDealController controller = new ViewDealController();
    ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("/jsp/addDeal.jsp", modelAndView.getViewName());
  }
}