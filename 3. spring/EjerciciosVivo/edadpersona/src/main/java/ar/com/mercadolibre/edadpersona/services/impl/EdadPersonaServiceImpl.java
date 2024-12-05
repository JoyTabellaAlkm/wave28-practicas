package ar.com.mercadolibre.edadpersona.services.impl;

import ar.com.mercadolibre.edadpersona.services.IEdadPersonaService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class EdadPersonaServiceImpl implements IEdadPersonaService {

    @Override
    public Integer convertirFechaAEdad(String day, String month, String year){
        LocalDate birthdate;
        LocalDate today;

        try{
            birthdate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month),Integer.parseInt(day));
            today = LocalDate.now();
            if(birthdate.isAfter(today)){
                throw new DateTimeException("La fecha es posterior a la fecha actual");
            }
        }catch(DateTimeException e){
            return -1;
        }

        Period period = Period.between(birthdate, today);

        return period.getYears();
    }
}
