package com.iterators.spring.example.disruptor.event.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author iterators
 * @date 2020.12.28
 */
@Getter
@Setter
public class LongEvent extends ApplicationEvent {

    public static final String SOURCE = "LongEvent";

    private Long number;

    /**
     * Create a new {@code ApplicationEvent}.
     */
    public LongEvent() {
        super(SOURCE);
    }

    public LongEvent(Long number) {
        super(SOURCE);
        this.number = number;
    }
}
