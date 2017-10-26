package com.bloomberg.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloomberg.inventory.dao.InvalidDealDao;
import com.bloomberg.inventory.jpa.InvalidDeal;
import com.bloomberg.inventory.service.InvalidDealService;

/**
 * This is a implementation of the DealService Class.
 *
 */
@Service
@Transactional
public class InvalidDealServiceImpl implements InvalidDealService
{

  @Autowired
  private InvalidDealDao invalidDealDao;

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.service.DealService#listDeals()
   */
  @Transactional(readOnly = true)
  @Override
  public List<InvalidDeal> listDeals()
  {
    return invalidDealDao.listDeals();
  }

  @Override
  public void add(List<InvalidDeal> deals)
  {
    invalidDealDao.add(deals);

  }

}
