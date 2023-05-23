package com.github.mawen12.document;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.mapping.TypeMapping;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.IndexSettings;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;



public class IndexOperationDemo {
    
    private static ElasticsearchClient esClient;

    private static ElasticsearchTransport transport;

    static {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();   
        
        transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        esClient = new ElasticsearchClient(transport);        
    }

    public static void main(String[] args) throws IOException {
        //create();
        delete();
    }

    public static void create() throws IOException {
        CreateIndexRequest.Builder createRequestBuilder = new CreateIndexRequest.Builder();

        createRequestBuilder.index("test");

        IndexSettings indexSettings = IndexSettings.of(b -> b
                        .refreshInterval(t -> t.time("2s"))
                        .numberOfShards("2")
                        .numberOfReplicas("2")
        );
        createRequestBuilder.settings(indexSettings);

        Map<String, JsonData> map = new HashMap<>();
        map.put("name", JsonData.of("mawen"));
        map.put("_class", JsonData.of("keyword"));
        TypeMapping typeMapping = TypeMapping.of(b -> b.meta(map));
        createRequestBuilder.mappings(typeMapping);

        CreateIndexRequest request = createRequestBuilder.build();

        CreateIndexResponse response = transport.performRequest(request, CreateIndexRequest._ENDPOINT, null);
        
        System.out.println(response.acknowledged());
    }

    public static void delete() throws IOException {
        DeleteIndexRequest.Builder deleteRequestBuilder = new DeleteIndexRequest.Builder();
        
        deleteRequestBuilder.index("test");

        DeleteIndexRequest request = deleteRequestBuilder.build();

        DeleteIndexResponse response = transport.performRequest(request, DeleteIndexRequest._ENDPOINT, null);

        System.out.println(response.acknowledged());
    }
}
