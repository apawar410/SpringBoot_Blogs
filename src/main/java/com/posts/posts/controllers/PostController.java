package com.posts.posts.controllers;

import com.posts.posts.exception.ResourceNotFoundException;
import com.posts.posts.models.Post;
import com.posts.posts.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping ("/postGet")
    public Post createPost (@RequestBody Post posts) {
       return postRepository.save (posts);
    }

    @GetMapping ("/getposts")
    public Page<Post> getAllPosts (Pageable pageable) {
        return postRepository.findAll (pageable);
    }

    @DeleteMapping ("/posts/{postid}")
    public ResponseEntity <?> deletePost (@PathVariable Long postid) {
        return postRepository.findById (postid).map(posts -> {
                    postRepository.delete(posts);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postid + " not found"));
    }
}
