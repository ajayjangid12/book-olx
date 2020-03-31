package com.example.booksolx.service;

import com.example.booksolx.model.Post;
import com.example.booksolx.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        Post postTemp = post;
        String name = post.getName();
        String postedBy = post.getPostedBy();
        String[] arr = name.split(" ");
        String postId = "";
        for(int i=0;i<arr.length;i++)
            postId+=arr[i]+"-";
        postId+=postedBy;
        postTemp.setPostId(postId);
        postTemp = postRepository.save(postTemp);
        return postTemp;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }



    public List<Post> getPostsByCategory(String category) {
        return postRepository.findByCategory(category);
    }

    public Post getPost(String postId) {
        return postRepository.findByPostId(postId);
    }

    public List<Post> getPostsByPostedBy(String postedBy) {
        return postRepository.findByPostedBy(postedBy);
    }

    public Boolean deleteByPostId(String postId) {
        Post postTemp = postRepository.findByPostId(postId);
        postRepository.delete(postTemp);
        return true;
    }

    public Post updatePost(Post post) {
        Post postTemp = postRepository.findByPostId(post.getPostId());
        postTemp.setName(post.getName());
        postTemp.setCategory(post.getCategory());
        postTemp.setDescription(post.getDescription());
        postTemp.setImgsrc(post.getImgsrc());
        postTemp.setPrice(post.getPrice());
        Post updatedPost = postRepository.save(postTemp);
        return updatedPost;
    }

    public List<Post> getSearchedPosts(String keyword) {
        List<Post> postList = postRepository.findAll();
        List<Post> resultList = new ArrayList<>();
        for(int i=0;i<postList.size();i++){
            if(postList.get(i).getName().toLowerCase().contains(keyword.toLowerCase())||
                postList.get(i).getCategory().toLowerCase().contains(keyword.toLowerCase())||
                    postList.get(i).getDescription().toLowerCase().contains(keyword.toLowerCase())){
                resultList.add(postList.get(i));
            }
        }
        return resultList;
    }

    public List<Post> getPostsByKeywordAndCategory(String keyword, String category) {
        List<Post> postList = getSearchedPosts(keyword);
        List<Post> resultList = new ArrayList<>();
        for(int i=0;i<postList.size();i++){
            if(postList.get(i).getCategory().equalsIgnoreCase(category)){
                resultList.add(postList.get(i));
            }
        }
        return resultList;
    }

    public Boolean checkDataValid(Post post) {
        Post postTemp = postRepository.findByNameAndPostedBy(post.getName(),post.getPostedBy());
        if(postTemp==null)
            return true;
        return false;
    }


}
