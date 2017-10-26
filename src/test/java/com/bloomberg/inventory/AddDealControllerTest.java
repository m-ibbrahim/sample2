package com.bloomberg.inventory;

import org.springframework.web.servlet.ModelAndView;

import com.bloomberg.inventory.controller.AddDealController;

import junit.framework.TestCase;


public class AddDealControllerTest extends TestCase
{
  public void testHandleRequestView() throws Exception
  {
    AddDealController controller = new AddDealController();
    ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("jsp/addDeal.jsp", modelAndView.getViewName());
  }
}