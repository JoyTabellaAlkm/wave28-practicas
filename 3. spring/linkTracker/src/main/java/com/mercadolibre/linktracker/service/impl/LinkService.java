package com.mercadolibre.linktracker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.dto.LinkResponseDto;
import com.mercadolibre.linktracker.exception.InvalidPasswordException;
import com.mercadolibre.linktracker.exception.InvalidUrlException;
import com.mercadolibre.linktracker.exception.ResourceNotFoundException;
import com.mercadolibre.linktracker.model.Link;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;
    private final ObjectMapper objectMapper;

    public LinkService(ILinkRepository linkRepository, ObjectMapper objectMapper) {
        this.linkRepository = linkRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public LinkResponseDto createLink(LinkRequestDto link) {
        validLink(link.getLink());
        Link linkResponse = linkRepository.createLink(objectMapper.convertValue(link, Link.class));
        return objectMapper.convertValue(linkResponse, LinkResponseDto.class);
    }

    @Override
    public String redirect(Integer id, String password) {
        Link link = validateExistingLink(id);
        validatePassword(link, password);
        link.incrementCounter();
        return link.getLink();
    }

    @Override
    public Integer getMetrics(Integer id) {
        return validateExistingLink(id).getCounter();
    }

    @Override
    public String invalidateLink(Integer id) {
        Link link = validateExistingLink(id);
        linkRepository.invalidateLink(link);
        return "Se invalidó el link con id " + id;
    }

    private Link validateExistingLink(Integer id) {
        Optional<Link> link = linkRepository.findById(id);
        if (link.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró la URL con el id " + id);
        }
        return link.get();
    }

    private void validLink(String link) {
        String regex = "^((https?|ftp)://)?[a-zA-Z0-9.-]+(\\.[a-zA-Z]{2,})+(:[0-9]{1,5})?(/\\S*)?(\\?[;&a-zA-Z0-9%_=-]*)?(#\\S*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(link);
        if (!matcher.matches()) {
            throw new InvalidUrlException("La URL ingresada no es válida");
        }
    }

    private void validatePassword(Link link, String password) {
        if (!link.getPassword().equals(password)) {
            throw new InvalidPasswordException("La contraseña proporcionada no es correcta para el link solicitado");
        }
    }
}
