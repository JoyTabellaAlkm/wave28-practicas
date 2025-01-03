package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO() {
  }

  public HouseResponseDTO(HouseDTO house, Integer squareFeet, Integer price, RoomDTO biggest) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
    this.squareFeet = squareFeet;
    this.price = price;
    this.biggest = biggest;
  }

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }
}
