package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDTO;

public interface ILinkService {
    LinkDTO createLink(LinkDTO linkDTO);
    Integer countRedirections(Integer linkId);
    String redirect(Integer linkId);
}
