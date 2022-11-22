package seckill.dormsystem.response;

import lombok.Data;

@Data
public class BaseResponse<T> {
    // 状态码
    private Integer code;
    // 接口消息
    private String message;
    // 接口数据
    private T data;

    /**
     * 默认构造方法
     * @param code 状态码
     * @param message 接口消息
     * @param data 接口数据
     */
    public BaseResponse(Integer code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 默认构造方法
     */
    public BaseResponse() {
        super();
    }
}
