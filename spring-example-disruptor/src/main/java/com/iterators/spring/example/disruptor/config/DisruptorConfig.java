package com.iterators.spring.example.disruptor.config;

import com.iterators.spring.example.disruptor.event.entity.LongEvent;
import com.iterators.spring.example.disruptor.event.factory.LongEventFactory;
import com.iterators.spring.example.disruptor.event.handler.LongEventHandler;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author iterators
 * @date 2020.12.28
 */
@Configuration
public class DisruptorConfig {

    @Bean
    public Disruptor<LongEvent> disruptor(EventFactory eventFactory, EventHandler eventHandler) {
        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, bufferSize, DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(eventHandler);
        return disruptor;
    }

    @Bean
    public EventFactory eventFactory() {
        return new LongEventFactory();
    }

    @Bean
    public EventHandler<LongEvent> eventHandler() {
        return new LongEventHandler();
    }
}
