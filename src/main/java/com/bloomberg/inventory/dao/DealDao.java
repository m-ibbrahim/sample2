package com.bloomberg.inventory.dao;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

/**
 * This interface defines the data operations to be implemented for the table "DEAL"
 *
 */
public interface DealDao
{
  /**
   * Adds an Invalid deal to the table "DEAL"
   * 
   * @param deal
   */
  void add(Deal deal);

  /**
   * Removes an Invalid deal to the table "DEAL"
   * 
   * @param deal
   */
  void remove(Deal deal);

  /**
   * Get the list of Invalid deals from the table "DEAL"
   * 
   * @return
   */
  List<Deal> listDeals();

  /**
   * Adds an Invalid deal to the table "DEAL"
   * 
   * @param deal
   */
  void add(List<Deal> deal);
}