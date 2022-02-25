package com.posts.posts.repositories;

import com.posts.posts.models.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository <Comments,Long> {
    Page<Comments> findByPostsId (Long postId, Pageable pageable);
    Optional <Comments> findByIdAndPostsId (Long id, Long postId);

}
