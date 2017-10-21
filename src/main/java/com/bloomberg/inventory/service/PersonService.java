package com.bloomberg.inventory.service;

import java.util.List;

import com.bloomberg.inventory.jpa.Person;

public interface PersonService
{
  void add(Person person);

  List<Person> listPersons();
}