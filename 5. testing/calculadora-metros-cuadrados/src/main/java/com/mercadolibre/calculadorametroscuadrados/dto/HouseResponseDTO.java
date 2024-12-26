package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;


@Setter
@Getter
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

}
