package com.company.permission.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author candylove
 * @date 2024/11/28 15:12
 */
@Data
@TableName("sys_user")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户对象")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "登录账户")
    private String userName;

    @Schema(description = "登录密码")
    private String password;

    @Schema(description = "用户电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "0.男 1.女")
    private String sex;

    @Schema(description = "是否为超级管理员(1.是 0.否)")
    private Integer isAdmin;

    @Schema(description = "账户是否可用(1.可用 2.删除)")
    private Integer isEnable;

    @Schema(description = "姓名")
    private String nickName;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
    private Date ctime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyy-MM-dd", timezone = "GMT+8")
    private Date utime;
}