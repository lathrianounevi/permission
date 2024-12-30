package com.company.permission.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author candylove
 * @date 2024/11/29 15:42
 */
@Data
@Schema(description = "角色请求对象")
public class RoleRequest {

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
