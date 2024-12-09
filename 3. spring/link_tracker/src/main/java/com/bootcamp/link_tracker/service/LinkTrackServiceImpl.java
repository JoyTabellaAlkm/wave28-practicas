package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkTrackDTO;
import com.bootcamp.link_tracker.exception.LinkTrackNotValidException;
import com.bootcamp.link_tracker.repository.LinkTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkTrackServiceImpl implements LinkTrackService {

    private final LinkTrackRepository linkTrackRepository;

    @Autowired
    public LinkTrackServiceImpl(LinkTrackRepository linkTrackRepository) {
        this.linkTrackRepository = linkTrackRepository;
    }

    @Override
    public LinkTrackDTO createLinkTrack(LinkTrackDTO linkTrackDTO) {
        linkTrackDTO.setLink_url("/link/" + linkTrackDTO.getId());
        return linkTrackRepository.save(linkTrackDTO);
    }

    @Override
    public List<LinkTrackDTO> findAll() {
        return linkTrackRepository.findAll();
    }

    @Override
    public LinkTrackDTO findById(Long id) {
        return linkTrackRepository.findById(id);
    }

    @Override
    public String redirectById(Long linkId) {
        // 1. encontrar el link
        LinkTrackDTO linkTrackDTO = linkTrackRepository.findById(linkId);
        // 2. validar que esté activo
        if(!linkTrackDTO.is_active()) {
            throw new LinkTrackNotValidException("El link no se encuentra activo");
        }
        // 3. incrementar el numero de visitas
        linkTrackDTO.setTimes_called(linkTrackDTO.getTimes_called() + 1);
        // 4. persistir el nuevo numero de visitas
        linkTrackRepository.update(linkTrackDTO);
        // 5. redireccionar al cliente
        return linkTrackDTO.getUrl();
    }
}
