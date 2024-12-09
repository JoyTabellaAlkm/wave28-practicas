package com.bootcamp.links.service;

import com.bootcamp.links.dto.LinkDTO;

public interface ILinkService {

    LinkDTO agregarLink(String url);

    LinkDTO redireccionar(Integer linkId);

}
