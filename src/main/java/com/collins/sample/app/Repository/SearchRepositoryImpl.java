package com.collins.sample.app.Repository;

import com.collins.sample.app.Models.Post;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import org.bson.Document;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoConverter converter;
    @Autowired
    MongoClient client;
    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("sample-app");
        MongoCollection<Document> collection = database.getCollection("posts");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", "maths")
                                                .append("path", Arrays.asList("tech", "desc", "profile")))),
                new Document("$sort",
                        new Document("profile", "hello world"))));

      result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }
}
