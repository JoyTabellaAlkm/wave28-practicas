package com.bootcamp.links.repository;

import com.bootcamp.links.model.Link;

import java.util.HashMap;

public interface ILinkRepository {

    Link agregarLink(Link link);

    Link obtenerLink(Integer linkId);

}
