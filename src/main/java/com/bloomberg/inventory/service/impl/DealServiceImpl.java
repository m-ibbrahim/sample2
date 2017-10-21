package com.bloomberg.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloomberg.inventory.dao.DealDao;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.service.DealService;

@Service
public class DealServiceImpl implements DealService
{

  @Autowired
  private DealDao dealDao;

  @Transactional
  @Override
  public void add(Deal person)
  {
    dealDao.add(person);
  }

  @Transactional
  @Override
  public void remove(Deal person)
  {
    dealDao.remove(person);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Deal> listDeals()
  {
    return dealDao.listDeals();
  }

}
