package com.company.permission.admin.controller;

import com.company.permission.common.model.Role;
import com.company.permission.common.request.PageParamRequest;
import com.company.permission.common.request.RoleRequest;
import com.company.permission.common.response.CommonResult;
import com.company.permission.common.response.RoleResponse;
import com.company.permission.service.service.RoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author candylove
 * @date 2024/12/3 14:39
 */
@RestController
@RequestMapping("/admin/role")
@Tag(name = "角色管理")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Operation(summary = "保存(更新)角色")
    @PostMapping("/save")
    public CommonResult<Long> save(@RequestBody RoleRequest request) {
        return CommonResult.success(roleService.save(request));
    }

    @Operation(summary = "角色分页列表")
    @PostMapping ("/getList")
    public CommonResult<PageInfo<Role>> getList(@RequestBody @Validated PageParamRequest request) {
        return CommonResult.success(roleService.getList(request));
    }

    @Operation(summary = "根据id获取角色")
    @GetMapping("/getOneById")
    public CommonResult<Role> getOneById(@RequestParam Long id) {
        return CommonResult.success(roleService.getOneById(id));
    }

}
