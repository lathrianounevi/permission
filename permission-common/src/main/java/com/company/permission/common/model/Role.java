package com.company.permission.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author candylove
 * @date 2024/11/28 15:12
 */
@Data
@TableName("sys_role")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "角色对象")
public class Role implements Serializable {

    @TableId(value = "role_id", type = IdType.AUTO)
    @Schema(description = "角色id")
    private Long RoleId;

    @Schema(description = "角色名称")
    private String RoleName;

    @Schema(description = "扩展字段")
    private String type;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

}
