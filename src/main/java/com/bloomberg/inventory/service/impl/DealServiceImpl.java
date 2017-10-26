package com.bloomberg.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloomberg.inventory.dao.DealDao;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.service.DealService;

/**
 * This is a implementation of the DealService Class.
 *
 */
@Service
public class DealServiceImpl implements DealService
{

  @Autowired
  private DealDao dealDao;

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.service.DealService#add(com.bloomberg.inventory.jpa .Deal)
   */
  @Transactional
  @Override
  public void add(Deal person)
  {
    dealDao.add(person);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.service.DealService#remove(com.bloomberg.inventory. jpa.Deal)
   */
  @Transactional
  @Override
  public void remove(Deal person)
  {
    dealDao.remove(person);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.service.DealService#listDeals()
   */
  @Transactional(readOnly = true)
  @Override
  public List<Deal> listDeals()
  {
    return dealDao.listDeals();
  }

  @Transactional
  @Override
  public void add(List<Deal> deals)
  {
    dealDao.add(deals);

  }

}
