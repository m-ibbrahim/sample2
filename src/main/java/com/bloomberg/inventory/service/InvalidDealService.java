package com.bloomberg.inventory.service;

import java.util.List;

import com.bloomberg.inventory.jpa.InvalidDeal;

/**
 * This is a service class for INVALID_DEAL which exposes all the methods to be used by the controllers.
 * 
 */
public interface InvalidDealService
{

  /**
   * @param deals
   */
  void add(List<InvalidDeal> deals);

  /**
   * @return
   */
  List<InvalidDeal> listDeals();

}