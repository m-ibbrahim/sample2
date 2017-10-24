package com.bloomberg.inventory.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bloomberg.inventory.dao.DealDao;
import com.bloomberg.inventory.jpa.Deal;

/**
 * 
 *
 */
@Repository
public class DealDaoImpl implements DealDao
{

  /**
   * 
   */
  @PersistenceContext
  private EntityManager em;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.bloomberg.inventory.dao.DealDao#add(com.bloomberg.inventory.jpa.Deal)
   */
  @Override
  public void add(Deal person)
  {
    em.persist(person);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.bloomberg.inventory.dao.DealDao#listDeals()
   */
  @Override
  public List<Deal> listDeals()
  {
    CriteriaQuery<Deal> criteriaQuery = em.getCriteriaBuilder().createQuery(Deal.class);
    @SuppressWarnings("unused")
    Root<Deal> root = criteriaQuery.from(Deal.class);
    return em.createQuery(criteriaQuery).getResultList();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.bloomberg.inventory.dao.DealDao#remove(com.bloomberg.inventory.jpa.
   * Deal)
   */
  @Override
  public void remove(Deal person)
  {
    em.remove(em.contains(person) ? person : em.merge(person));
  }

}
