package seckill.dormsystem.common.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import seckill.dormsystem.common.domain.QueueEnum;


public class BaseRabbitMqConfig {
    /**
     * 订单消费队列绑定交换机
     * @return
     */
    @Bean
    DirectExchange orderDirect() {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单消费队列
     * @return
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QueueEnum.QUEUE_ORDER.getName());
    }

    /**
     * 将订单队列绑定到交换机
     * @param orderDirect
     * @param orderQueue
     * @return
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirect, Queue orderQueue) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_ORDER.getRouteKey());
    }

    /**
     * 消息转换器，将消息转换为JSON格式
     * @return
     */
    @Bean
    public MessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

