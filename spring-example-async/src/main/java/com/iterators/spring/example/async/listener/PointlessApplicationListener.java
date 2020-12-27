package com.iterators.spring.example.async.listener;

import com.iterators.spring.example.async.event.entity.PointlessEvent;
import com.iterators.spring.example.async.event.publisher.CustomEventPublisher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author iterators
 * @date 2020.12.27
 */
@Component
public class PointlessApplicationListener implements ApplicationRunner {

    private final CustomEventPublisher eventPublisher;

    public PointlessApplicationListener(CustomEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventPublisher.publish(new PointlessEvent("pointless"));
    }
}
