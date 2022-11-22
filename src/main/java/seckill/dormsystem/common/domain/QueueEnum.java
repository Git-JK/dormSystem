package seckill.dormsystem.common.domain;

import lombok.Getter;

@Getter
public enum QueueEnum {
    QUEUE_ORDER("dormSystem.order.direct", "dormSystem.order.kill", "dormSystem.order.kill");
    private final String exchange;
    private final String name;
    private final String routeKey;
    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
