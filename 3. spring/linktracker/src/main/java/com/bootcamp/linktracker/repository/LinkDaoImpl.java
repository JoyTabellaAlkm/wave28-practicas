package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkDaoImpl implements ILinkDao {

    private List<LinkDTO> data = new ArrayList<>();

    @Override
    public Optional<LinkDTO> getNewestLink() {
        return Optional.ofNullable(data.size() == 0 ? null : data.get(data.size()-1));
    }

    @Override
    public void create(LinkDTO linkDTO) {
        data.add(linkDTO);
    }

    @Override
    public Optional<LinkDTO> findById(Integer linkId) {
        return data.stream().filter(dto -> dto.getId().equals(linkId)).findFirst();
    }
}
