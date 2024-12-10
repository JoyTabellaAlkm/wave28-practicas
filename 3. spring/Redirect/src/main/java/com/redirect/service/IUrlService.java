package com.redirect.service;

import com.redirect.dto.UrlDTO;
import com.redirect.dto.response.EstatsDTO;
import com.redirect.dto.response.IdUrlDTO;
import com.redirect.dto.response.StatusUrlDTO;

import java.net.URISyntaxException;

public interface IUrlService {

    IdUrlDTO createUrl(UrlDTO urlDTO) throws URISyntaxException;

    UrlDTO getUrl(IdUrlDTO idUrlDTO);

    EstatsDTO getEstats(IdUrlDTO idUrlDTO);

    StatusUrlDTO disableUrl(IdUrlDTO idUrlDTO);
}
