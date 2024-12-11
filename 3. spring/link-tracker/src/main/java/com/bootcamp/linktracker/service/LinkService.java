package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkDto;
import com.bootcamp.linktracker.exception.LinkAlreadyExistsException;
import com.bootcamp.linktracker.exception.NotFoundException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LinkService implements ILinkService {
    private final LinkRepository linkRepository;
    private int lastLinkIndex = 0;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public int createLink(LinkDto linkDto) {
        String url = linkDto.getUrl();

        if (linkAlreadyExists(url))
            throw new LinkAlreadyExistsException("Ya existe un link para esa url");

        Link link = new Link(lastLinkIndex, url, linkDto.getPassword());
        lastLinkIndex++;

        return linkRepository.saveLink(link);
    }

    @Override
    public String redirectionUrl(int linkId, String password) {
        Link redirectionLink = getRedirectionLinkIfValid(linkId, password);

        redirectionLink.incrementTimesRedirected();

        return redirectionLink.getUrl();
    }

    @Override
    public int getMetrics(int linkId, String password) {
        Link redirectionLink = getRedirectionLinkIfValid(linkId, password);

        return redirectionLink.getTimesRedirected();
    }

    @Override
    public void invalidateLink(int linkId, String password) {
        Link link = getRedirectionLinkIfValid(linkId, password);

        linkRepository.deleteLink(link);
    }

    private Link getRedirectionLinkIfValid(int linkId, String password) {
        Link redirectionLink = getLinkById(linkId).orElseThrow(
                () -> new NotFoundException("Link ID o contraseña inválidos")
        );

        if (!redirectionLink.canBeAccessedWith(password)) {
            throw new NotFoundException("Link ID o contraseña inválidos");
        }
        return redirectionLink;
    }

    private Optional<Link> getLinkById(int linkId) {
        return linkRepository.getAllLinks()
                .stream()
                .filter(link -> Objects.equals(link.getLinkId(), linkId))
                .findAny();
    }

    private boolean linkAlreadyExists(String url) {
        return linkRepository.getAllLinks()
                .stream()
                .anyMatch(link -> Objects.equals(link.getUrl(), url));
    }
}
