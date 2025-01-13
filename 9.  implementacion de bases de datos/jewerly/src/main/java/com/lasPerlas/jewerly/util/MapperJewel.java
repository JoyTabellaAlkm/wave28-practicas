package com.lasPerlas.jewerly.util;

import com.lasPerlas.jewerly.dto.response.JewelDTO;
import com.lasPerlas.jewerly.dto.request.NewJewelDTO;
import com.lasPerlas.jewerly.model.Jewel;

public class MapperJewel {
    public static Jewel toEntity(NewJewelDTO jewel){
        Jewel jewelEntity = new Jewel();
        jewelEntity.setNombre(jewel.getNombre());
        jewelEntity.setMaterial(jewel.getMaterial());
        jewelEntity.setPeso(jewel.getPeso());
        jewelEntity.setParticularidad(jewel.getParticularidad());
        jewelEntity.setPoseePiedra(jewel.isPoseePiedra());
        jewelEntity.setVentaONo(jewel.isVentaONo());

        return jewelEntity;
    }

    public static JewelDTO toDTO(Jewel jewel){
        JewelDTO jewelDTO = new JewelDTO();
        jewelDTO.setNroIdentificatorio(jewel.getNroIdentificatorio());
        jewelDTO.setNombre(jewel.getNombre());
        jewelDTO.setMaterial(jewel.getMaterial());
        jewelDTO.setPeso(jewel.getPeso());
        jewelDTO.setParticularidad(jewel.getParticularidad());
        jewelDTO.setPoseePiedra(jewel.isPoseePiedra());
        jewelDTO.setVentaONo(jewel.isVentaONo());

        return jewelDTO;
    }

}
