package com.iterators.spring.example.async.event.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 异步发布事件
 *
 * @author iterators
 * @date 2020.12.27
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    /**
     * 发布事件
     */
    public void publish(ApplicationEvent event) {
        eventPublisher.publishEvent(event);
    }
}
