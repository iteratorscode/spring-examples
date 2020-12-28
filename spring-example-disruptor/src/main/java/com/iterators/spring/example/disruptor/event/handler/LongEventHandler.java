package com.iterators.spring.example.disruptor.event.handler;

import com.iterators.spring.example.disruptor.event.entity.LongEvent;
import com.lmax.disruptor.EventHandler;

/**
 * @author iterators
 * @date 2020.12.28
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }
}
