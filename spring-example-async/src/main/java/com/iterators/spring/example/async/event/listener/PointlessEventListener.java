package com.iterators.spring.example.async.event.listener;

import com.iterators.spring.example.async.event.entity.PointlessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author iterators
 * @date 2020.12.27
 */
@Component
@Slf4j
public class PointlessEventListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return PointlessEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("receive event: {}", event);
    }
}
