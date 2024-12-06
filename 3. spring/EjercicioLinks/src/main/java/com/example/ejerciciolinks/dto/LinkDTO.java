package com.example.ejerciciolinks.dto;

import com.example.ejerciciolinks.entity.Link;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinkDTO {
    private String url;
    private String password;

    public LinkDTO linkToLinkDto(Link link) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setUrl(link.getLink());
        linkDTO.setPassword(link.getPassword());
        return linkDTO;
    }

    public Link linkDtoToLink(LinkDTO linkDto) {
        Link link = new Link();
        link.setLink(linkDto.getUrl());
        link.setPassword(linkDto.getPassword());
        return link;
    }

}
