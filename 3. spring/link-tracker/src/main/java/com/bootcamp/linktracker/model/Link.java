package com.bootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int linkId;
    private String url;
    private String password;
    private int timesRedirected = 0;

    public Link(int linkId, String url, String password) {
        this.password = password;
        this.url = url;
        this.linkId = linkId;
    }

    public boolean canBeAccessedWith(String password) {
        if (noPasswordRequired()) return true;

        return Objects.equals(this.password, password);
    }

    public void incrementTimesRedirected() {
        timesRedirected++;
    }

    private boolean noPasswordRequired() {
        return password == null;
    }
}
