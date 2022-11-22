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
@TableName("sys")
@ApiModel(value = "Sys对象", description = "")
public class Sys implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("配置名称")
    @TableField("key_name")
    private String keyName;

    @ApiModelProperty("配置值")
    @TableField("key_value")
    private String keyValue;

    @ApiModelProperty("1代表删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("备注，仅管理员可见")
    @TableField("remarks")
    private String remarks;


}
