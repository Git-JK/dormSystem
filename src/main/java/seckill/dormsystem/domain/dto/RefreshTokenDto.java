package seckill.dormsystem.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "RefreshTokenDto对象", description = "authController.refreshToken到tokenService.refreshToken传递参数")
public class RefreshTokenDto {
    @ApiModelProperty("登录token")
    private String accessToken;

    @ApiModelProperty("刷新token")
    private String refreshToken;
}
