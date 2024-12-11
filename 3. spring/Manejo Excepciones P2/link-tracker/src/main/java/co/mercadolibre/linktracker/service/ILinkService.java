package co.mercadolibre.linktracker.service;

import co.mercadolibre.linktracker.dto.RequestLinkDTO;

public interface ILinkService {
    int createLink(RequestLinkDTO linkDTO);
    String getURL(int linkID, String password);
    int getMetrics(int linkID);
    String deleteLink(int linkID);
}
