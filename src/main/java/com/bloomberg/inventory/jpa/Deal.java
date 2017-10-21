package com.bloomberg.inventory.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEAL")
@Getter
@Setter
public class Deal
{

  public Deal()
  {

  }

  public Deal(String dealUniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode, String dealTimestamp, String dealAmount, String dealFilename)
  {
    super();
    this.dealUniqueId = dealUniqueId;
    this.fromCurrencyIsoCode = fromCurrencyIsoCode;
    this.toCurrencyIsoCode = toCurrencyIsoCode;
    this.dealTimestamp = dealTimestamp;
    this.dealAmount = dealAmount;
    this.dealFilename = dealFilename;
  }

  @Id
  @Column(name = "DEAL_UNIQUE_ID")
  private String dealUniqueId;

  @Column(name = "FROM_CURRENCY_ISO_CODE")
  private String fromCurrencyIsoCode;

  @Column(name = "TO_CURRENCY_ISO_CODE")
  private String toCurrencyIsoCode;

  @Column(name = "DEAL_TIMESTAMP")
  private String dealTimestamp;

  @Column(name = "DEAL_AMOUNT")
  private String dealAmount;

  @Column(name = "DEAL_FILENAME")
  private String dealFilename;

}
