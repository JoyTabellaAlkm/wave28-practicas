package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.*;

public interface ILinkService {
    ResponsePostCreacionLinkDto crearLink(RequestPostCreacionLinkDto request);

    ResponseRedireccion redireccionLink(RequestRedireccionDto request);

    ResponseMetricas obtenerMetricas(Long id);
}
