package com.bloomberg.inventory.dao;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

public interface DealDao
{
  void add(Deal deal);
  
  void remove(Deal deal);

  List<Deal> listDeals();
}