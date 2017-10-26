package com.bloomberg.inventory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bloomberg.inventory.dao.InvalidDealDao;
import com.bloomberg.inventory.jpa.InvalidDeal;

/**
 * 
 *
 */
@Repository
public class InvalidDealDaoImpl implements InvalidDealDao
{

  /**
   * 
   */
  @PersistenceContext
  private EntityManager em;

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.dao.DealDao#add(com.bloomberg.inventory.jpa.Deal)
   */
  @Override
  public void add(List<InvalidDeal> deals)
  {
    int batchSize = 10000;
    for (int i = 0; i < deals.size(); i++)
    {
      InvalidDeal deal = deals.get(i);
      em.persist(deal);
      if (i % batchSize == 0)
      {
        em.flush();
        em.clear();
      }
    }
    em.flush();
    em.clear();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.dao.DealDao#listDeals()
   */
  @Override
  public List<InvalidDeal> listDeals()
  {
    CriteriaQuery<InvalidDeal> criteriaQuery = em.getCriteriaBuilder().createQuery(InvalidDeal.class);
    @SuppressWarnings("unused")
    Root<InvalidDeal> root = criteriaQuery.from(InvalidDeal.class);
    return em.createQuery(criteriaQuery).getResultList();
  }

}
