package com.mercadolibre.elasticsearch.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContextBuilder;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mercadolibre.elasticsearch.repository")
public class ElasticsearchConfig {

    @Value("${spring.elasticsearch.uris}")
    private String serverUrl;

    @Value("${spring.elasticsearch.username}")
    private String username;

    @Value("${spring.elasticsearch.password}")
    private String password;

    @Bean
    ElasticsearchClient elasticsearchClient() {
        BasicCredentialsProvider credentials = new BasicCredentialsProvider();
        UsernamePasswordCredentials usernamePassword = new UsernamePasswordCredentials(username, password);
        credentials.setCredentials(AuthScope.ANY, usernamePassword);

        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setHttpClientConfigCallback(config -> {
                    try {
                        return config.setSSLContext(SSLContextBuilder.create()
                                .loadTrustMaterial(null, (chain, authType) -> true)
                                .build())
                                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                                .setDefaultCredentialsProvider(credentials);
                    } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
                        throw new RuntimeException();
                    }
                })
                .build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        // And create the API client
        return new ElasticsearchClient(transport);
    }

}
