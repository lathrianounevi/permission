package com.company.permission.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.permission.common.model.Role;
import com.company.permission.common.request.RoleRequest;
import com.company.permission.common.response.RoleResponse;

import java.util.List;

public interface RoleService extends IService<Role> {

    /**
     * 新增(更新)角色
     * @param request
     * @return Long
     */
    Long save(RoleRequest request);



    /**
     * 根据id获取详情
     * @param id
     * @return RoleRequest
     */
    RoleResponse getOneById(Long id);

}
