package com.inditex.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;


@Validated
public class PriceDTO   {
  @JsonProperty("productId")
  private Long productId = null;

  @JsonProperty("brandId")
  private Integer brandId = null;

  @JsonProperty("priceList")
  private Integer priceList = null;

  @JsonProperty("startDate")
  private String startDate = null;

  @JsonProperty("endDate")
  private String endDate = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("curr")
  private String curr = null;

  public PriceDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   **/  
    public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public PriceDTO brandId(Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Get brandId
   * @return brandId
   **/
    public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public PriceDTO priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Get priceList
   * @return priceList
   **/  
    public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PriceDTO startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/  
    public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public PriceDTO endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
   **/  
    public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public PriceDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/  
    public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public PriceDTO curr(String curr) {
    this.curr = curr;
    return this;
  }

  /**
   * Get curr
   * @return curr
   **/  
    public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceDTO priceDTO = (PriceDTO) o;
    return Objects.equals(this.productId, priceDTO.productId) &&
        Objects.equals(this.brandId, priceDTO.brandId) &&
        Objects.equals(this.priceList, priceDTO.priceList) &&
        Objects.equals(this.startDate, priceDTO.startDate) &&
        Objects.equals(this.endDate, priceDTO.endDate) &&
        Objects.equals(this.price, priceDTO.price) &&
        Objects.equals(this.curr, priceDTO.curr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceList, startDate, endDate, price, curr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceDTO {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    curr: ").append(toIndentedString(curr)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
