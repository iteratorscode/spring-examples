package com.iterators.spring.example.disruptor.runner;

import com.iterators.spring.example.disruptor.event.entity.LongEvent;
import com.iterators.spring.example.disruptor.event.publisher.EventPublisher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author iterators
 * @date 2020.12.28
 */
@Component
public class LongEventRunner implements ApplicationRunner {

    private final EventPublisher eventPublisher;

    public LongEventRunner(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (long i = 0L; i < 10L; i++) {
            LongEvent longEvent = new LongEvent();
            longEvent.setNumber(i);
            eventPublisher.publish(longEvent);
        }
    }
}
