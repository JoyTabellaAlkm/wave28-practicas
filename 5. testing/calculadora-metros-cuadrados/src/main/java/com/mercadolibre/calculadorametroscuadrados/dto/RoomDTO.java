package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.Objects;

public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO() {
  }

  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RoomDTO)) return false;
    RoomDTO roomDTO = (RoomDTO) o;
    return Objects.equals(getName(), roomDTO.getName()) && Objects.equals(getWidth(), roomDTO.getWidth()) && Objects.equals(getLength(), roomDTO.getLength());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getWidth(), getLength());
  }
}
