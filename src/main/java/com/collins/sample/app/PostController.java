package com.collins.sample.app;

import com.collins.sample.app.Models.Post;
import com.collins.sample.app.Repository.PostRepository;
import com.collins.sample.app.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SearchRepository searchRepository;
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepository.findByText(text);

    }
}
