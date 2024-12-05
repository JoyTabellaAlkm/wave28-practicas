package com.example.ejerciciolinks.repository;

import com.example.ejerciciolinks.dto.LinkDTO;
import com.example.ejerciciolinks.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{
    private HashMap<Integer, Link> database = new HashMap<>();

    @Override
    public Integer saveLink(Link newLink) {
        List<Link> allLink = this.getAllLink();
        newLink.setId(allLink.size());

        if (this.getLinkByUrl(newLink.getLink())==null){
            this.database.put(newLink.getId(), newLink);
            return newLink.getId();
        }
        else return null;
    }

    @Override
    public List<Link> getAllLink() {
        List<Link> allLinks = new ArrayList<>();
        for (Map.Entry<Integer, Link> entry: this.database.entrySet()) {
            allLinks.add(this.database.get(entry.getKey()));
        }
        return allLinks;
    }

    @Override
    public Link getLinkByUrl(String url) {
        for (Map.Entry<Integer, Link> entry: this.database.entrySet()) {
            if(url.equals(entry.getValue().getLink())){
                return entry.getValue();
            }
        }
        return null;
    }


    @Override
    public Link getLinkById(Integer linkId) {
        if (this.database.containsKey(linkId)){
            return this.database.get(linkId);
        }else return null;
    }

    @Override
    public Integer getLinkMetrics(Integer linkId) {
        return database.get(linkId).getContadorEstadistica();
    }

    @Override
    public void deleteLink(Integer linkId) {
        database.remove(linkId);
    }

    @Override
    public void updateLink(Link link) {
        this.database.put(link.getId(), link);
    }


}
