package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkDao {
    Optional<LinkDTO> getNewestLink();
    void create(LinkDTO linkDTO);

    Optional<LinkDTO> findById(Integer linkId);
    void update(LinkDTO link);
    void delete(LinkDTO linkDTO);
}
