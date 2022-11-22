package seckill.dormsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kk
 * @since 2022-11-22
 */
@Getter
@Setter
@TableName("auth")
@ApiModel(value = "Auth对象", description = "")
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("0-学号，1-邮箱，2-电话")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("user表中的uid")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("添加时间")
    @TableField("add_time")
    private Integer addTime;

    @ApiModelProperty("备注，仅管理员可见")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("1代表删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("备用")
    @TableField("status")
    private Integer status;


}
