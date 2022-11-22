package seckill.dormsystem.response;

public class RespGenerator {
    /**
     * 接口调用成功
     * @param message 成功信息
     * @param data 接口数据
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> returnOK(String message, T data) {
        return new BaseResponse<T>(200, message, data);
    }

    /**
     * 调用失败，返回错误信息
     * @param code 错误码
     * @param message 错误信息
     * @return
     */
    public static BaseResponse<Void> returnError(Integer code, String message) {
        return new BaseResponse<Void>(code, message, null);
    }
}
