package seckill.dormsystem.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import seckill.dormsystem.common.domain.BaseMessage;
import seckill.dormsystem.common.domain.QueueEnum;
import seckill.dormsystem.service.OrderSender;

import javax.annotation.Resource;

@Service
public class OrderSenderImpl implements OrderSender {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(BaseMessage<?> message) {
        String jsonMessage = JSON.toJSONString(message);
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_ORDER.getName(), jsonMessage);
    }
}
