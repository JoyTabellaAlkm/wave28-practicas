package com.redirect.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redirect.dto.UrlDTO;
import com.redirect.dto.response.EstatsDTO;
import com.redirect.dto.response.IdUrlDTO;
import com.redirect.dto.response.StatusUrlDTO;
import com.redirect.entity.Url;
import com.redirect.exceptions.UrlException;
import com.redirect.exceptions.UrlInvalidException;
import com.redirect.repository.UrlRepository;
import com.redirect.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class UrlServiceImpl implements IUrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public IdUrlDTO createUrl(UrlDTO urlDTO) throws URISyntaxException {
        URI newUrl = new URI(urlDTO.getUrl());
        if (newUrl.getHost() != null && newUrl.getScheme() != null){
            return objectMapper.convertValue(urlRepository.createUrl(urlDTO), IdUrlDTO.class);
        }
        else {
            throw new UrlInvalidException("url not valid");
        }
    }

    @Override
    public UrlDTO getUrl(IdUrlDTO idUrlDTO) {
        return objectMapper.convertValue(urlRepository.updateOpens(idUrlDTO), UrlDTO.class);
    }

    @Override
    public EstatsDTO getEstats(IdUrlDTO idUrlDTO) {
        List<Url> allUrls = urlRepository.getAllUrls();
        return allUrls.stream()
                .filter(u ->( u.getId().equals(idUrlDTO.getId()) && u.isActive() == true))
                .map(u -> objectMapper.convertValue(u, EstatsDTO.class))
                .findFirst()
                .orElseThrow(() -> new UrlException("Id not found"));
    }

    @Override
    public StatusUrlDTO disableUrl(IdUrlDTO idUrlDTO) {
        return objectMapper.convertValue(urlRepository.updateActive(idUrlDTO), StatusUrlDTO.class);
    }
}
