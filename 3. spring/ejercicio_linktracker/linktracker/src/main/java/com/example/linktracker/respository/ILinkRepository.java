package com.example.linktracker.respository;

import com.example.linktracker.entity.Link;

public interface ILinkRepository {
    int createLink(String link);
    Link getLinkById(int id);
    Integer getRedirectsCountById(int id);
}
