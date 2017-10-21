package com.bloomberg.inventory.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEAL")
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

  public String getDealUniqueId()
  {
    return dealUniqueId;
  }

  public void setDealUniqueId(String dealUniqueId)
  {
    this.dealUniqueId = dealUniqueId;
  }

  public String getFromCurrencyIsoCode()
  {
    return fromCurrencyIsoCode;
  }

  public void setFromCurrencyIsoCode(String fromCurrencyIsoCode)
  {
    this.fromCurrencyIsoCode = fromCurrencyIsoCode;
  }

  public String getToCurrencyIsoCode()
  {
    return toCurrencyIsoCode;
  }

  public void setToCurrencyIsoCode(String toCurrencyIsoCode)
  {
    this.toCurrencyIsoCode = toCurrencyIsoCode;
  }

  public String getDealTimestamp()
  {
    return dealTimestamp;
  }

  public void setDealTimestamp(String dealTimestamp)
  {
    this.dealTimestamp = dealTimestamp;
  }

  public String getDealAmount()
  {
    return dealAmount;
  }

  public void setDealAmount(String dealAmount)
  {
    this.dealAmount = dealAmount;
  }

  public String getDealFilename()
  {
    return dealFilename;
  }

  public void setDealFilename(String dealFilename)
  {
    this.dealFilename = dealFilename;
  }

}
