package seckill.dormsystem.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import seckill.dormsystem.common.domain.BaseMessage;
import seckill.dormsystem.common.domain.QueueEnum;
import seckill.dormsystem.service.OrderReceiver;

import javax.annotation.Resource;

@Service
public class OrderReceiverImpl implements OrderReceiver {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    @RabbitListener(queues = "dormSystem.order.kill")
    public void receive(String jsonMessage) {
        BaseMessage<?> message = JSON.toJavaObject(JSON.parseObject(jsonMessage), BaseMessage.class);
    }
}
