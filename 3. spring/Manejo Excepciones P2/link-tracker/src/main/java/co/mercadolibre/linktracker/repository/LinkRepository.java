package co.mercadolibre.linktracker.repository;

import co.mercadolibre.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements IRepository{

    private final Map<Integer, Link> repo;

    public LinkRepository(){
        repo = new HashMap<>();
    }

    @Override
    public int addLink(Link link) {
        repo.put(link.getLinkID(), link);
        return link.getLinkID();
    }

    @Override
    public Link getLink(int id) {
        return repo.get(id);
    }

    @Override
    public int deleteLink(int id) {
        repo.remove(id);
        return id;
    }

    @Override
    public int getLinksSize(){
        return repo.size();
    }

    @Override
    public void addCount(Link link) {
        repo.get(link.getLinkID()).setRedirectionCounter(link.getRedirectionCounter()+1);
    }
}
