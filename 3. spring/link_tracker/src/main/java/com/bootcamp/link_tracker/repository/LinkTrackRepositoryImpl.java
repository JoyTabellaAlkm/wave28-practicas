package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.dto.LinkTrackDTO;
import com.bootcamp.link_tracker.exception.LinkNotFoundException;
import com.bootcamp.link_tracker.exception.LinkTrackConflictException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkTrackRepositoryImpl implements LinkTrackRepository {

    private final List<LinkTrackDTO> linkTrackDTOList = new ArrayList<>();

    @Override
    public List<LinkTrackDTO> findAll() {
        return linkTrackDTOList;
    }

    @Override
    public LinkTrackDTO save(LinkTrackDTO linkTrack) {
        Optional<LinkTrackDTO> linkTrackDTO = linkTrackDTOList
                .stream()
                .filter(link -> link.getId().equals(linkTrack.getId()))
                .findFirst();
        if(linkTrackDTO.isPresent()) {
            throw new LinkTrackConflictException("No se pudo crear el link ya que el id " + linkTrack.getId() + " ya existe.");
        }
        linkTrackDTOList.add(linkTrack);
        return linkTrack;
    }

    @Override
    public LinkTrackDTO findById(Long id) {
        Optional<LinkTrackDTO> linkTrackDTO = linkTrackDTOList
                .stream()
                .filter(link -> link.getId().equals(id))
                .findFirst();
        if(linkTrackDTO.isEmpty()) {
            throw new LinkNotFoundException("El link con el id " + id + " no existe.");
        }
        return linkTrackDTO.get();
    }

    @Override
    public LinkTrackDTO update(LinkTrackDTO linkTrack) {
        LinkTrackDTO existingListTrack = findById(linkTrack.getId());
        int existingPos = linkTrackDTOList.indexOf(existingListTrack);
        linkTrackDTOList.set(existingPos, linkTrack);
        return linkTrack;
    }
}
