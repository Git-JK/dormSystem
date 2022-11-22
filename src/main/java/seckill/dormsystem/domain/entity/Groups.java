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
@TableName("groups")
@ApiModel(value = "Groups对象", description = "")
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("队伍名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("加入口令")
    @TableField("invite_code")
    private String inviteCode;

    @ApiModelProperty("队伍描述，用户可见")
    @TableField("describe")
    private String describe;

    @ApiModelProperty("只有队伍中没有其他成员，方可删除")
    @TableField("is_del")
    private Integer isDel;

    @ApiModelProperty("如果改组分配宿舍成功，置为1，将不可以再进行队伍的操作")
    @TableField("status")
    private Integer status;


}
