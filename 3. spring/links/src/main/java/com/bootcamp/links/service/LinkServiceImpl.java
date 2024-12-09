package com.bootcamp.links.service;

import com.bootcamp.links.dto.LinkDTO;
import com.bootcamp.links.exception.NotFoundException;
import com.bootcamp.links.exception.URLNotValidException;
import com.bootcamp.links.model.Link;
import com.bootcamp.links.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    private Integer linkId = 0;

    ObjectMapper mapper = new ObjectMapper();

    // Patrón de expresión regular para validar URLs
    private static final String URL_REGEX =
            "^(https?:\\/\\/)" + // Protocolo
                    "((([a-zA-Z\\d]([a-zA-Z\\d-]*[a-zA-Z\\d])*)\\.)+[a-zA-Z]{2,})" + // Dominio
                    "(\\:\\d+)?(\\/[-a-zA-Z\\d%@_.~+&:]*)*" + // Puerto y path
                    "(\\?[;&a-zA-Z\\d%@_.,~+&:=-]*)?" + // Query
                    "(\\#[-a-zA-Z\\d_]*)?$"; // Fragmento
    private static final Pattern pattern = Pattern.compile(URL_REGEX);
    /**
     * Valida si la URL proporcionada es válida.
     *
     * @param url La URL a validar.
     * @return true si la URL es válida, false de lo contrario.
     */
    public static boolean isValid(String url) {
        if (url == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    private static final int CODE_LENGTH = 6;
    private static final SecureRandom random = new SecureRandom();
    /**
     * Genera un código corto alfanumérico de longitud fija.
     *
     * @return El código corto generado.
     */
    public static String generateShortCode() {
        StringBuilder shortCode = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            shortCode.append(randomAlphanumeric());
        }
        return shortCode.toString();
    }
    /**
     * Genera un carácter alfanumérico aleatorio (A-Z, a-z, 0-9) sin usar una variable de alfabeto.
     *
     * @return Un carácter alfanumérico aleatorio.
     */
    private static char randomAlphanumeric() {
        int rand = random.nextInt(62); // 26 mayúsculas + 26 minúsculas + 10 dígitos = 62
        if (rand < 26) {
            return (char) ('A' + rand); // 'A' - 'Z'
        } else if (rand < 52) {
            return (char) ('a' + rand - 26); // 'a' - 'z'
        } else {
            return (char) ('0' + rand - 52); // '0' - '9'
        }
    }

    @Override
    public LinkDTO agregarLink(String url) {

        if(!isValid(url)) {
            throw new URLNotValidException("La URL no es válida.");
        }

        String shortUrl = "https://localhost:8080/link/" + generateShortCode();

        Link link = linkRepository.agregarLink(new Link(linkId++, url, shortUrl, 0));

        return mapper.convertValue(link, LinkDTO.class);
    }

    @Override
    public LinkDTO redireccionar(Integer linkId) {

        Link link = linkRepository.obtenerLink(linkId);

        //link.setContador(link.getContador()++);

        if(link == null) {
            throw new NotFoundException("La URL no fue encontrada.");
        }

        return mapper.convertValue(link, LinkDTO.class);
    }


}
