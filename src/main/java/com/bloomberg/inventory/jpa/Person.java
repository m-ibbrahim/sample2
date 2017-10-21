package com.bloomberg.inventory.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSONS")
@Getter
@Setter
public class Person
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  public Person()
  {
  }

  public Person(String firstName, String lastName, String email)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // Getter and Setter methods
}