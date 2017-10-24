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

  /**
   * @param deal
   */
  void remove(Deal deal);

  /**
   * @return
   */
  List<Deal> listDeals();
}