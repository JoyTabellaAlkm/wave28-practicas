package com.example.Ejercicio_LinkTracker.service;

import com.example.Ejercicio_LinkTracker.dto.LinkDto;
import com.example.Ejercicio_LinkTracker.exception.UrlNotFoundException;
import com.example.Ejercicio_LinkTracker.model.Link;
import com.example.Ejercicio_LinkTracker.repository.ILinkRepository;
import com.example.Ejercicio_LinkTracker.repository.LinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkService implements ILinkService{

    private final LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public int create(LinkDto linkDto) {
        Link link = new Link(creaLinkId(),linkDto.getUrl(), linkDto.getPassword(), 0);
        repository.create(link);
        return link.getLinkId();
    }

    private int creaLinkId(){
        return repository.getSize()+1;
    }

    //----------------
    public RedirectView redirect(int id) {
        String url = repository.getListaLinks().get(id).getUrl();
        if (url != null) {
            return new RedirectView(url);
        } else {
            throw new UrlNotFoundException("Url no encontrada");
        }
    }


}
