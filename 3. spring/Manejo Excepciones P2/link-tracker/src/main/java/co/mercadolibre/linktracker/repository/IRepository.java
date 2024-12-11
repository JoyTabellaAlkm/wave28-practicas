package co.mercadolibre.linktracker.repository;

import co.mercadolibre.linktracker.model.Link;

public interface IRepository {
    int addLink(Link link);
    Link getLink(int id);
    int deleteLink(int id);
    int getLinksSize();
    void addCount(Link link);
}
