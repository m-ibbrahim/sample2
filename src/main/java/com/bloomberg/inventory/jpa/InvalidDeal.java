package com.bloomberg.inventory.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * This is an entity class representing the INVALID_DEALS table.
 *
 */
@Entity
@Table(name = "INVALID_DEALS")
@Getter
@Setter
public class InvalidDeal
{

  /**
   * Default constructor for this class
   */
  public InvalidDeal()
  {

  }

  /**
   * @param dealUniqueId
   * @param fromCurrencyIsoCode
   * @param toCurrencyIsoCode
   * @param dealTimestamp
   * @param dealAmount
   * @param dealFilename
   */
  public InvalidDeal(String dealUniqueId, String fromCurrencyIsoCode, String toCurrencyIsoCode, String dealTimestamp, String dealAmount, String dealFilename)
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
