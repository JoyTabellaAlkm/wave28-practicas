package com.elasticsearch.obrasliterarias.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.elasticsearch.obrasliterarias.repository")
public class ElasticConfig {
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClient restClient = RestClient
                .builder(HttpHost.create("http://localhost:9200"))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey CIS2GZGAQjuzQ7_QUIu4dQ")
                })
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper()
        );

        return new ElasticsearchClient(transport);
    }
}
