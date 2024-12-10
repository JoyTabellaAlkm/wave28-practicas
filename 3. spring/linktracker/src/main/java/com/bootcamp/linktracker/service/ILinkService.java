package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkService {
    LinkDTO createLink(LinkDTO linkDTO);
    Integer countRedirections(Integer linkId);
    String redirect(Integer linkId, Optional<String> password);
    void invalidate(Integer linkId);
}
