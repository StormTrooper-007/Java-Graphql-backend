package com.collins.sample.app.Repository;

import com.collins.sample.app.Models.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
