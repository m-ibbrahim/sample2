package com.bloomberg.inventory.service;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

/**
 * 
 *
 */
public interface DealService
{
  /**
   * @param deal
   */
  void add(Deal deal);

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