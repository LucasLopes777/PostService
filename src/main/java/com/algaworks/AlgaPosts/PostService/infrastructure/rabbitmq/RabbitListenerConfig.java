package com.algaworks.AlgaPosts.PostService.infrastructure.rabbitmq;

import com.algaworks.AlgaPosts.PostService.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitListenerConfig {

    private final PostService postService;

    @RabbitListener(queues = RabbitConfig.RESULT_QUEUE)
    public void consumeProcessing() {
        postService.updatePostInfo(result);
    }

}
