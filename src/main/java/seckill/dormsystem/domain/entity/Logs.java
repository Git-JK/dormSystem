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
@TableName("logs")
@ApiModel(value = "Logs对象", description = "")
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("操作用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("操作模块名称")
    @TableField("operation")
    private String operation;

    @ApiModelProperty("客户端IP")
    @TableField("client_ip")
    private String clientIp;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Integer createTime;

    @ApiModelProperty("操作详情")
    @TableField("content")
    private String content;

    @ApiModelProperty("0 成功 1 失败")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("1代表删除")
    @TableField("is_del")
    private Integer isDel;


}
