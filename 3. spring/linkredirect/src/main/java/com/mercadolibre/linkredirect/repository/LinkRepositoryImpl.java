package com.mercadolibre.linkredirect.repository;

import com.mercadolibre.linkredirect.model.Link;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    Map<Long,Link> repository;
    Long id;

    public LinkRepositoryImpl(){
        this.id = 1L;
        this.repository = new HashMap<>();
    }

    @Override
    public Long addLink(Link link) {
        link.setId(id);
        repository.put(id,link);
        return id ++;
    }

    @Override
    public List<Link> getAll() {
        return repository.values().stream().toList();
    }

    @Override
    public Link getById(Long id) {
        return repository.get(id);
    }
}
