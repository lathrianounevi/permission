package com.company.permission.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.permission.common.model.Role;
import com.company.permission.common.request.RoleRequest;

import java.util.List;

public interface RoleDao extends BaseMapper<Role> {

    List<Role> getList();

}
