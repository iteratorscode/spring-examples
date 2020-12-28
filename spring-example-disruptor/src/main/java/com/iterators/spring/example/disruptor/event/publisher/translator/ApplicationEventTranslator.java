package com.iterators.spring.example.disruptor.event.publisher.translator;

import com.lmax.disruptor.EventTranslator;
import org.springframework.context.ApplicationEvent;

/**
 * @author iterators
 * @date 2020.12.28
 */
public class ApplicationEventTranslator implements EventTranslator<ApplicationEvent> {

    @Override
    public void translateTo(ApplicationEvent event, long l) {

    }
}
