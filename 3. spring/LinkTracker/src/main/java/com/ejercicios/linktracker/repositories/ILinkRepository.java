package com.ejercicios.linktracker.repositories;

import com.ejercicios.linktracker.models.LinkModel;

public interface ILinkRepository {
    public LinkModel addLink(String link);
    public LinkModel findById(int id);
    public void countRedirect(int id);
}
