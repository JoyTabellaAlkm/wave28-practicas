package com.redirect.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redirect.dto.UrlDTO;
import com.redirect.dto.response.IdUrlDTO;
import com.redirect.entity.Url;
import com.redirect.exceptions.UrlException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UrlRepository {
    private List<Url> urls;
    private ObjectMapper objectMapper = new ObjectMapper();

    public UrlRepository(){
        urls =  getAllUrls();
    }

    public List<Url> getAllUrls(){
        List<Url> allUrls = new ArrayList<>();
        try{
            File file = ResourceUtils.getFile("classpath:json/urls.json");
            allUrls = objectMapper.readValue(file, new TypeReference<List<Url>>() {});
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            allUrls = new ArrayList<>();
        }
        System.out.println(allUrls);
        return allUrls;
    }

    public Url createUrl(UrlDTO url) throws URISyntaxException {
        Url createdUrl = new Url(
                "url" + (urls.size() + 1),
                url.getUrl(),
                0,
                true
        );
        urls.add(createdUrl);
        return createdUrl;
    }

    public Url updateOpens(IdUrlDTO urlId){
        Url getUrl = urls.stream()
                .filter(url -> (url.getId().equals(urlId.getId()) && url.isActive()))
                .findFirst()
                .orElseThrow(() -> new UrlException("Id not found"));
        getUrl.setOpens(getUrl.getOpens() + 1);
        return getUrl;
    }

    public Url updateActive(IdUrlDTO id){
        Url getUrl = urls.stream()
                .filter(url -> (url.getId().equals(id.getId()) && url.isActive()))
                .findFirst()
                .orElseThrow(() -> new UrlException("Id not found"));
        getUrl.setActive(false);
        return getUrl;
    }
}
