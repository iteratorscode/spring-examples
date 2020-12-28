package com.iterators.spring.example.disruptor.event.factory;

import com.iterators.spring.example.disruptor.event.entity.LongEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author iterators
 * @date 2020.12.28
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
