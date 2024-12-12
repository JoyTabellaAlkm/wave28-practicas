package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.MensajeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{


    private final NativeWebRequest nativeWebRequest;
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, NativeWebRequest nativeWebRequest){
        this.vehicleRepository = vehicleRepository;
        this.nativeWebRequest = nativeWebRequest;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    /*
    @Override
    public String deleteVehicle(Integer id) {

        // llamar al repository
        return vehicleRepository.deleteVehicleRepository(id);

    }
*/

    public String deleteVehicle(long id){
            List<VehicleDto> listVehicleDTO= searchAllVehicles();

            // filtra hasta encontrar un solo vehiculo
            VehicleDto vehicleDto= listVehicleDTO.stream().filter(v->v.getId()==id)
                    .findAny().orElse(null);

            if (vehicleDto == null) {
                throw new NotFoundException("Vehiculo no encontrado");
            }

            // cambia de vehiculoDTO a vehiculo
            Vehicle vehicle = new Vehicle();
            ObjectMapper mapper = new ObjectMapper();
            vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            // Llamar al repositorio para eliminar el vehículo
            String message = vehicleRepository.deleteVehicleRepository(vehicle);

            // Crear el MensajeDto con el mensaje de respuesta
            MensajeDto respuesta = new MensajeDto();
            respuesta.setMenssaje(message);

            // llamar al repository
            return respuesta.getMenssaje();

        }



    }



