package com.example.linktracker.respository;

public interface ILinkRepository {
    int createLink(String link);
    String getLinkById(int id);
}
