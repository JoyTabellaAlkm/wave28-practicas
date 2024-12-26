package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO() {

  }

}
