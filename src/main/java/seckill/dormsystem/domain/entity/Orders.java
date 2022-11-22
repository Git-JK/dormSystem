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
@TableName("orders")
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("提交人，user表中的id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("groups表中的id，如果未组队，该值为0")
    @TableField("group_id")
    private Integer groupId;

    @ApiModelProperty("building表中的id")
    @TableField("building_id")
    private Integer buildingId;

    @ApiModelProperty("下单时间，用户提交表单时间")
    @TableField("submit_time")
    private Integer submitTime;

    @ApiModelProperty("订单生成时间，仅后台可见")
    @TableField("create_time")
    private Integer createTime;

    @ApiModelProperty("订单完成时间，仅后台可见")
    @TableField("finish_time")
    private Integer finishTime;

    @ApiModelProperty("room表中的id")
    @TableField("room_id")
    private Integer roomId;

    @ApiModelProperty("订单处理结果（如什么原因失败，或者分配了哪个宿舍），用户可见")
    @TableField("result_content")
    private String resultContent;

    @ApiModelProperty("备注，仅管理员可见")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("1代表删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("0未处理，1处理成功，2处理失败")
    @TableField("status")
    private Integer status;


}
