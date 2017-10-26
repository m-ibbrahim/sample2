package com.bloomberg.inventory.dao;

import java.util.List;

import com.bloomberg.inventory.jpa.InvalidDeal;

/**
 * This interface defines the data operations to be implemented for the table "INVALID_DEAL"
 *
 */
public interface InvalidDealDao
{
  /**
   * Get the list of Invalid deals from the table "INVALID_DEAL"
   * 
   * @return
   */
  List<InvalidDeal> listDeals();

  /**
   * Adds an Invalid deal to the table "INVALID_DEAL"
   * 
   * @param deal
   */
  void add(List<InvalidDeal> deal);
}