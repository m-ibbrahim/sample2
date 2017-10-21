package com.bloomberg.inventory.service;

import java.util.List;

import com.bloomberg.inventory.jpa.Deal;

public interface DealService
{
  void add(Deal deal);
  
  void remove(Deal deal);

  List<Deal> listDeals();
}