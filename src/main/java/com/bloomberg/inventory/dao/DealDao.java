package com.bloomberg.inventory.dao;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

/**
 * 
 *
 */
public interface DealDao
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

  void add(List<Deal> deal);
}