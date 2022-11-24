package seckill.dormsystem.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "LoginBo对象", description = "login操作传出参数")
public class LoginBo {
    @ApiModelProperty("访问token")
    private String accessToken;
    @ApiModelProperty("token类型, bearer")
    private String tokenType;
    @ApiModelProperty("过期时间")
    private long expiresIn;
    @ApiModelProperty("权限范围")
    private String scope;
    @ApiModelProperty("刷新token")
    private String refreshToken;
}
