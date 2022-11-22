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
@TableName("groups_user")
@ApiModel(value = "GroupsUser对象", description = "")
public class GroupsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("user表中的id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("是否为创建人，1为是，0为否")
    @TableField("is_creator")
    private Integer isCreator;

    @ApiModelProperty("	groups表中的id")
    @TableField("group_id")
    private Integer groupId;

    @ApiModelProperty("1代表删除，离开前置为1")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("加入时间")
    @TableField("join_time")
    private Integer joinTime;

    @ApiModelProperty("离开时间")
    @TableField("leave_time")
    private Integer leaveTime;

    @ApiModelProperty("备用")
    @TableField("status")
    private Integer status;


}
