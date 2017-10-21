package com.bloomberg.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloomberg.inventory.dao.PersonDao;
import com.bloomberg.inventory.jpa.Person;

@Service
public class PersonServiceImpl implements PersonService
{

  @Autowired
  private PersonDao userDao;

  @Transactional
  @Override
  public void add(Person person)
  {
    userDao.add(person);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Person> listPersons()
  {
    return userDao.listPersons();
  }

}
