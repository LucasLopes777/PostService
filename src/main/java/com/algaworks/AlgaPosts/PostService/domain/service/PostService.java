package com.algaworks.AlgaPosts.PostService.domain.service;

import com.algaworks.AlgaPosts.PostService.api.model.PostInput;
import com.algaworks.AlgaPosts.PostService.api.model.PostOutput;
import com.algaworks.AlgaPosts.PostService.api.model.PostProcessingRequest;
import com.algaworks.AlgaPosts.PostService.domain.model.Post;
import com.algaworks.AlgaPosts.PostService.domain.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.algaworks.AlgaPosts.PostService.infrastructure.rabbitmq.RabbitConfig.POST_QUEUE;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AmqpTemplate amqpTemplate;

    @Transactional
    public PostOutput create(PostInput postInput) {

        UUID id = UUID.randomUUID();

        Post post = new Post();
        post.setId(id);
        post.setTitle(postInput.getTitle());
        post.setBody(postInput.getBody());
        post.setAuthor(postInput.getAuthor());

        postRepository.saveAndFlush(post);

        amqpTemplate.convertAndSend(POST_QUEUE, new PostProcessingRequest(id, postInput.getBody()));

        return new PostOutput(id, post.getTitle(), post.getBody(),
                post.getAuthor(), null, null);

    }


    @Transactional
    public void updatePostInfo() {

    }

}
