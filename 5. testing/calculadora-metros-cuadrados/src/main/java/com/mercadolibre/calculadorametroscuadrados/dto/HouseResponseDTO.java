package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.Objects;

public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO() {
  }

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }

  public Integer getSquareFeet() {
    return squareFeet;
  }

  public void setSquareFeet(Integer squareFeet) {
    this.squareFeet = squareFeet;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public RoomDTO getBiggest() {
    return biggest;
  }

  public void setBiggest(RoomDTO biggest) {
    this.biggest = biggest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HouseResponseDTO)) return false;
    HouseResponseDTO that = (HouseResponseDTO) o;
    return Objects.equals(getSquareFeet(), that.getSquareFeet()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getBiggest(), that.getBiggest());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSquareFeet(), getPrice(), getBiggest());
  }
}
