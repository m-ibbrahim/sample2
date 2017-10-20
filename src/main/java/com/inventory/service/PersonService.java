package com.inventory.service;

import java.util.List;

import com.inventory.jpa.Person;

public interface PersonService
{
  void add(Person person);

  List<Person> listPersons();
}