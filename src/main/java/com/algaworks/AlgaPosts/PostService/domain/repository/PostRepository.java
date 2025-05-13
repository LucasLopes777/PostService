package com.algaworks.AlgaPosts.PostService.domain.repository;


import com.algaworks.AlgaPosts.PostService.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
