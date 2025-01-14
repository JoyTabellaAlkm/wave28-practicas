package com.obras_literarias.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "*")
public class Config {
    @Bean
    public RestHighLevelClient cliente(){
        String host = "127.0.0.1";
        int port = 9200;


        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        RestClientBuilder builder = RestClient
                .builder(new HttpHost(host, port))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Content-type", "application/json")
                })
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        RestHighLevelClient client = new RestHighLevelClient(builder);

        return client;

    }
}
