package seckill.dormsystem.service;

import seckill.dormsystem.common.domain.BaseMessage;

public interface OrderSender {
    /**
     * 将消息传送到订单消息队列
     * @param message
     */
    void send(BaseMessage<?> message);
}
