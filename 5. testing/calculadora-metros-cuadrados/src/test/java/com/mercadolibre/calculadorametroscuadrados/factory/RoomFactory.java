package com.mercadolibre.calculadorametroscuadrados.factory;

import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class RoomFactory {
    public static RoomDTO createBigRoomDTO() {
        RoomDTO bigRoom = new RoomDTO();
        bigRoom.setName("Big room");
        bigRoom.setWidth(200);
        bigRoom.setLength(400);

        return bigRoom;
    }

    public static RoomDTO createMediumRoomDTO() {
        RoomDTO mediumRoom = new RoomDTO();
        mediumRoom.setName("Medium room");
        mediumRoom.setWidth(150);
        mediumRoom.setLength(200);

        return mediumRoom;
    }

    public static RoomDTO createSmallRoomDTO() {
        RoomDTO smallRoom = new RoomDTO();
        smallRoom.setName("Small room");
        smallRoom.setWidth(100);
        smallRoom.setLength(50);

        return smallRoom;
    }
}
