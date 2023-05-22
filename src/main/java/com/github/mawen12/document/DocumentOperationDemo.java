package com.github.mawen12.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import com.github.mawen12.document.DocumentOperationDemo.Person;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DocumentOperationDemo {
    
    private static ElasticsearchClient esClient;

    static {
        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();   
        
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        esClient = new ElasticsearchClient(transport);        
    }

    public static void main(String[] args) throws Exception {
       //connect();
       //index();
       //get();
       //update();
       //delete();
       //exists();
       bulk();
    }

    public static void connect() throws ElasticsearchException, IOException {
        InfoResponse info = esClient.info();
        System.out.println(info);

    }

    public static void index() throws ElasticsearchException, IOException {
        Person person = Person.builder()
                            .id(1L)
                            .name("mawen")
                            .age(20)
                            .build();

        IndexResponse indexResponse = esClient.index(i -> i.index("person").id(Objects.toString(person.getId())).document(person));
        
        System.out.println(indexResponse.version());
    }

    public static void get() throws ElasticsearchException, IOException {
        GetResponse<Person> response = esClient.get(g -> g.index("person").id("1"), Person.class);
        
        if (response.found()) {
            Person person = response.source();
            System.out.println(person);
        }
    }

    public static void update() throws ElasticsearchException, IOException {
        Person newPerson = Person.builder()
                                .id(1L)
                                .name("lucy")
                                .age(10)
                                .build();

        UpdateResponse<Person> response = esClient.update(u -> u.index("person").id("1").doc(newPerson), Person.class);

        System.out.println(response.version());
    }

    public static void delete() throws ElasticsearchException, IOException {
        DeleteResponse response = esClient.delete(d -> d.index("person").id("1"));

        System.out.println(response.result());
    }

    public static void exists() throws ElasticsearchException, IOException {
        BooleanResponse response = esClient.exists(e -> e.index("person").id("1"));

        System.out.println(response.value());
    }

    public static void bulk() throws ElasticsearchException, IOException {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().id(1L).name("mawen").age(20).build());
        persons.add(Person.builder().id(2L).name("jack").age(30).build());
        persons.add(Person.builder().id(3L).name("lucy").age(40).build());


        List<BulkOperation> bks = new ArrayList<>();
        for (Person p : persons) {
            bks.add(BulkOperation.of(b -> b.index(i -> i.index("person").id(Objects.toString(p.getId())).document(p))));
        }

        BulkResponse response = esClient.bulk(b -> b.operations(bks));

        System.out.println(response.errors());
    }

    

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        private Long id;

        private String name;

        private Integer age;
    }
}
