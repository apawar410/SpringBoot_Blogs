package com.posts.posts.controllers;

import com.posts.posts.exception.ResourceNotFoundException;
import com.posts.posts.models.Comments;
import com.posts.posts.repositories.CommentRepository;
import com.posts.posts.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController

public class CommentController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @PostMapping ("/posts/{postId}/comments")
    public <comment> Comments createComment (@PathVariable (value = "postId") Long postId, @RequestBody Comments comment) {
        return postRepository.findById (postId).map(post->{
            comment.setPosts(post);
            return commentRepository.save (comment);
        }).orElseThrow (()-> new ResourceNotFoundException ("PostId " + postId + "Not found"));
    }


    @GetMapping ("posts/{postId}/comments")
    public Page<Comments> getAllCommentsByPostId (@PathVariable (value = "postId") Long postId, Pageable pageable) {
        return commentRepository.findByPostsId (postId,pageable);
    }


}
