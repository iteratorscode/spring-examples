package com.iterators.spring.example.async.event.entity;

import org.springframework.context.ApplicationEvent;

/**
 * @author iterators
 * @date 2020.12.27
 */
public class PointlessEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     */
    public PointlessEvent(Object source) {
        super(source);
    }
}
