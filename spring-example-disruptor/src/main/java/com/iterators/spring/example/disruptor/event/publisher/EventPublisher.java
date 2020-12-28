package com.iterators.spring.example.disruptor.event.publisher;

import com.iterators.spring.example.disruptor.event.entity.LongEvent;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author iterators
 * @date 2020.12.28
 */
@Component
public class EventPublisher implements ApplicationContextAware, InitializingBean {

    private ApplicationContext context;
    private RingBuffer<LongEvent> ringBuffer;
    private EventTranslator eventTranslator;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Disruptor disruptor = context.getBean(Disruptor.class);
        ringBuffer = disruptor.getRingBuffer();
        // eventTranslator = context.getBean(EventTranslator.class);
        disruptor.start();
    }

    /**
     * 发布事件
     */
    public void publish(LongEvent applicationEvent) {
        this.ringBuffer.publishEvent((event, sequence) -> event.setNumber(applicationEvent.getNumber()));
    }
}
