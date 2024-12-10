package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Link {
    private int linkId;
    private String link;
    private boolean valid = true;
    private int redirectsCount = 0;

    public Link(int linkId, String link) {
        this.linkId = linkId;
        this.link = link;
    }

    public void incrementRedirectsCount(){
        this.redirectsCount++;
    }

    public void invalidate(){
        this.valid = false;
    }
}
