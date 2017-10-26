package com.bloomberg.inventory.service;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

/**
 * This is a service class for DEAL which exposes all the methods to be used by the controllers.
 *
 */
public interface DealService
{
  /**
   * @param deal
   */
  void add(Deal deal);

  /**
   * @param deals
   */
  void add(List<Deal> deals);

  /**
   * @param deal
   */
  void remove(Deal deal);

  /**
   * @return
   */
  List<Deal> listDeals();

}