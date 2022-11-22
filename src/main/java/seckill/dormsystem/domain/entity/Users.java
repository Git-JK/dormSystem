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
@TableName("users")
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增，系统中其他表中的uid字段引用该字段")
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别：0为女 1为男")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty("电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话号码")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("1为学生。此字段保留方便以后扩展")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("添加时间")
    @TableField("add_time")
    private Integer addTime;

    @ApiModelProperty("是否禁止使用系统，1为禁止，0为允许登录")
    @TableField("is_deny")
    private Integer isDeny;

    @ApiModelProperty("最后一次登录时间")
    @TableField("last_login_time")
    private Integer lastLoginTime;

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
