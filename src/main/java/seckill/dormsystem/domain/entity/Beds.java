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
@TableName("beds")
@ApiModel(value = "Beds对象", description = "")
public class Beds implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("user表中的id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("room表中的id")
    @TableField("room_id")
    private Integer roomId;

    @ApiModelProperty("床编号")
    @TableField("name")
    private String name;

    @ApiModelProperty("排序号码，号码小的在前面")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty("是否有效，无效的床位不参加在线选择")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty("备注，仅管理员可见")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("1代表删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("0 空闲 1 已选")
    @TableField("status")
    private Integer status;


}
