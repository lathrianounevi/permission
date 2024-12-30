package com.company.permission.admin.controller;

import com.company.permission.common.model.User;
import com.company.permission.common.request.PageParamRequest;
import com.company.permission.common.request.UserRequest;
import com.company.permission.common.response.CommonResult;
import com.company.permission.common.response.UserResponse;
import com.company.permission.service.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author candylove
 * @date 2024/11/28 16:35
 */
@RestController
@RequestMapping("/admin/user")
@Tag(name = "用户管理")
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "新增(更新)用户")
    @PostMapping("/save")
    public CommonResult<Long> save(@RequestBody UserRequest request) {
        return CommonResult.success(userService.save(request));
    }

    @Operation(summary = "用户分页列表")
    @PostMapping("/getList")
    public CommonResult<PageInfo<UserResponse>> getList(@RequestBody PageParamRequest request) {
        return CommonResult.success(userService.getList(request));
    }

    @Operation(summary = "根据id获取用户")
    @GetMapping("/getOneById")
    public CommonResult<User> getOneById(@RequestParam Long id) {
        return CommonResult.success(userService.getOneById(id));
    }

}
