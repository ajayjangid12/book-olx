package com.example.booksolx.controller;

import com.example.booksolx.model.Post;
import com.example.booksolx.service.PostService;
import com.example.booksolx.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/post/create")
    public Post createPost(@RequestBody Post post){
        Post postTemp = postService.createPost(post);
        return postTemp;
    }

    @PostMapping("/post/update")
    public Post updatePost(@RequestBody Post post){
        Post postTemp = postService.updatePost(post);
        return postTemp;
    }

    @GetMapping("/posts/search/category/{category}")
    public List<Post> getPostsByCategory(@PathVariable String category){
        return postService.getPostsByCategory(category);
    }

    @PostMapping("/post")
    public Post getPost(@RequestBody String postId){
        return postService.getPost(postId);
    }

    @GetMapping("/posts/postedBy/{postedBy}")
    public List<Post> getPostsByPostedBy(@PathVariable String postedBy){
        return postService.getPostsByPostedBy(postedBy);
    }

    @GetMapping("/post/delete/{postId}")
    public Boolean deleteByPostId(@PathVariable String postId){
        return postService.deleteByPostId(postId);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/search/keyword/{keyword}")
    public List<Post> getSearchedPosts(@PathVariable String keyword){
        return postService.getSearchedPosts(keyword);
    }

    @GetMapping("/posts/search/{category}/{keyword}")
    public List<Post> getPostsByKeywordAndCategory(@PathVariable String category,@PathVariable String keyword){
        return postService.getPostsByKeywordAndCategory(keyword,category);
    }

    @GetMapping("/posts/deleteAll")
    public String deleteAllPosts(){
        postService.deleteAllPosts();
        return "all posts deleted";
    }

    @PostMapping("/post/dataValid")
    public boolean dataValid(@RequestBody Post post){
        return postService.checkDataValid(post);
    }

    @GetMapping("/add-to-wishlist/{userName}/{postId}")
    public boolean addToWishlist(@PathVariable String userName,@PathVariable String postId){
        return wishlistService.addToWishlist(userName,postId);
    }

    @GetMapping("wishlist/{userName}")
    public List<String> getWishlist(@PathVariable String userName){
        return wishlistService.getWishlist(userName);
    }

    @GetMapping("in-my-wishlist/{userName}/{postId}")
    public boolean inMyWishlist(@PathVariable String userName,@PathVariable String postId){
        return wishlistService.inMyWishlist(userName,postId);
    }

    @GetMapping("remove-from-wishlist/{userName}/{postId}")
    public Boolean removeFromWishlist(@PathVariable String userName,@PathVariable String postId){
        return wishlistService.removeFromWishlist(userName,postId);
    }

}
