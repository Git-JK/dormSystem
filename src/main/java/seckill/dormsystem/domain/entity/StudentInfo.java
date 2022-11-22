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
@TableName("student_info")
@ApiModel(value = "StudentInfo对象", description = "")
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("user表中的id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("学号")
    @TableField("studentid")
    private String studentid;

    @ApiModelProperty("校验码")
    @TableField("verification_code")
    private String verificationCode;

    @ApiModelProperty("班级id")
    @TableField("class_id")
    private Integer classId;

    @ApiModelProperty("备注，仅管理员可见")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty("备用")
    @TableField("status")
    private Integer status;


}
