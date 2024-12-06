package ar.com.mercadolibre.starwars.repository;

import ar.com.mercadolibre.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepository {
    private List<Personaje> listaPersonajes;


    public List<Personaje> readJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("starwarsData.json");
            listaPersonajes = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Personaje>>(){});
            System.out.println(listaPersonajes);
        }catch(IOException e){
            System.out.println("Error abriendo archivo: " + e.getMessage());
        }
        return listaPersonajes;
    }
}