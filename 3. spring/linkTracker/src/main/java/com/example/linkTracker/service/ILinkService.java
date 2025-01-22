package com.example.linkTracker.service;

import com.example.linkTracker.dto.*;

public interface ILinkService {
    ResponseCreationLinkDto crearLink(ResquestCreateLinkDto request);

    ResponseRedirectionDto redireccionLink(ResquestRedirectionDto request);

    ResponseMetricasDto obtenerMetricas(Long id);
}
