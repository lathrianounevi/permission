package com.company.permission.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.permission.common.model.Role;
import com.company.permission.common.request.PageParamRequest;
import com.company.permission.common.request.RoleRequest;
import com.company.permission.common.response.RoleResponse;
import com.github.pagehelper.PageInfo;

public interface RoleService extends IService<Role> {

    /**
     * 新增(更新)角色
     * @param request
     * @return Long
     */
    Long save(RoleRequest request);

    /**
     * 角色分页列表
     * @param request
     * @return Page
     */
    PageInfo<Role> getList(PageParamRequest request);

    /**
     * 根据id获取详情
     * @param id
     * @return RoleRequest
     */
    Role getOneById(Long id);

}
