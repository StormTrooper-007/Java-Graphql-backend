package com.collins.sample.app.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.collins.sample.app.Models.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
