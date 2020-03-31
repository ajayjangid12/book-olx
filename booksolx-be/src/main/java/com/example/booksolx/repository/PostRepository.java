package com.example.booksolx.repository;

import com.example.booksolx.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    Post findByNameAndPostedBy(String name, String postedBy);

    List<Post> findByCategory(String category);

    Post findByPostId(String postId);

    List<Post> findByPostedBy(String postedBy);
}
