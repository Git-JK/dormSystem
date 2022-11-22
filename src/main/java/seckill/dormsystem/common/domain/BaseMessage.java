package seckill.dormsystem.common.domain;

import lombok.Data;

@Data
public class BaseMessage<T> {
    private int id;
    private String type;
    private T data;
}
