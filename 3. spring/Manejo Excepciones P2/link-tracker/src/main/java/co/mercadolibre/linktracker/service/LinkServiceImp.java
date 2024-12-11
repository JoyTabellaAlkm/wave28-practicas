package co.mercadolibre.linktracker.service;

import co.mercadolibre.linktracker.dto.RequestLinkDTO;
import co.mercadolibre.linktracker.exception.InvalidLinkException;
import co.mercadolibre.linktracker.exception.InvalidLinkPasswordException;
import co.mercadolibre.linktracker.exception.LinkNotFoundException;
import co.mercadolibre.linktracker.model.Link;
import co.mercadolibre.linktracker.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class LinkServiceImp implements ILinkService{

    @Autowired
    IRepository repo;

    @Override
    public int createLink(RequestLinkDTO linkDTO) {
        return repo.addLink(new Link(
                repo.getLinksSize()+1, linkDTO.getUrl(), linkDTO.getPassword(), 0
        ));
    }

    @Override
    public String getURL(int linkID, String password) {
        Link link = repo.getLink(linkID);
        if(link == null) throw new LinkNotFoundException("El ID "+linkID+" no se encuentra registrado");
        try{
            new URL(link.getUrl());
        }catch (Exception e) {
            throw new InvalidLinkException("La URL del ID proporcionado es inválida, inhabilitelo y cree uno nuevo con una URL válida");
        }
        if(link.getPassword() != null && !link.getPassword().equals(password))
            throw new InvalidLinkPasswordException("Contraseña incorrecta");
        repo.addCount(link);
        return link.getUrl();
    }

    @Override
    public int getMetrics(int linkID) {
        return repo.getLink(linkID).getRedirectionCounter();
    }

    @Override
    public String deleteLink(int linkID) {
        if(repo.getLink(linkID) == null) throw new LinkNotFoundException("El ID "+linkID+" no se encuentra registrado");
        return "Se eliminó el link con id: "+ repo.deleteLink(linkID);
    }
}
