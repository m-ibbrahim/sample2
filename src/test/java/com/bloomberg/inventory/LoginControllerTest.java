package com.bloomberg.inventory;

import org.springframework.web.servlet.ModelAndView;

import com.bloomberg.inventory.controller.LoginController;

import junit.framework.TestCase;

public class LoginControllerTest extends TestCase
{
  public void testHandleRequestView() throws Exception
  {
    LoginController controller = new LoginController();
    ModelAndView modelAndView = controller.handleRequest(null, null);
    assertEquals("/jsp/addDeal.jsp", modelAndView.getViewName());
  }
}