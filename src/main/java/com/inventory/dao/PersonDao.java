package com.inventory.dao;

import java.util.List;

import com.inventory.jpa.Person;

public interface PersonDao
{
  void add(Person person);

  List<Person> listPersons();
}