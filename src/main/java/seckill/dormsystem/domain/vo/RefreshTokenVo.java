package seckill.dormsystem.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "refreshTokenVo对象", description = "refreshToken接口输入参数")
public class RefreshTokenVo {
    @ApiModelProperty("刷新token")
    private String refreshToken;
}
