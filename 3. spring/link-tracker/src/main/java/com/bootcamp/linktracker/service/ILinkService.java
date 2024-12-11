package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDto;

public interface ILinkService {
    int createLink(LinkDto linkDto);

    String redirectionUrl(int linkId, String password);

    int getMetrics(int linkId, String password);

    void invalidateLink(int linkId, String password);
}
