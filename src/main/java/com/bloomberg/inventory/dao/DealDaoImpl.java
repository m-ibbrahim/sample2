package com.bloomberg.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bloomberg.inventory.jpa.Deal;

@Repository
public class DealDaoImpl implements DealDao
{

  @PersistenceContext
  private EntityManager em;

  @Override
  public void add(Deal person)
  {
    em.persist(person);
  }

  @Override
  public List<Deal> listDeals()
  {
    CriteriaQuery<Deal> criteriaQuery = em.getCriteriaBuilder().createQuery(Deal.class);
    @SuppressWarnings("unused")
    Root<Deal> root = criteriaQuery.from(Deal.class);
    return em.createQuery(criteriaQuery).getResultList();
  }

}
