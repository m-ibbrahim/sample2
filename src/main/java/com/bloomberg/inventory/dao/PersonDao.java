package com.bloomberg.inventory.dao;

import java.util.List;

import com.bloomberg.inventory.jpa.Person;

public interface PersonDao
{
  void add(Person person);

  List<Person> listPersons();
}