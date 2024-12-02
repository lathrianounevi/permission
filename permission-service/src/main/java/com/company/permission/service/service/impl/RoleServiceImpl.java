package com.company.permission.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.permission.common.exception.BizException;
import com.company.permission.common.model.Role;
import com.company.permission.common.request.RoleRequest;
import com.company.permission.common.response.RoleResponse;
import com.company.permission.service.dao.RoleDao;
import com.company.permission.service.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author candylove
 * @date 2024/11/29 15:44
 */
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public Long save(RoleRequest request) {
        Assert.notNull(request.getRoleName(), "角色名称不能为空");
        Role role = new Role();
        BeanUtils.copyProperties(request, role);
        LambdaQueryWrapper<Role> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Role::getRoleName, request.getRoleName());
        Role dbRole = getOne(lqw);
        if (Objects.isNull(role.getRoleId())) {
            if (Objects.nonNull(dbRole)) {
                throw new BizException("角色名称不能重复");
            }
            save(role);
        } else {
            if (Objects.nonNull(dbRole) && Objects.equals(dbRole.getRoleId(), role.getRoleId())) {
                throw new BizException("角色名称不能重复");
            }
            updateById(role);
        }
        return role.getRoleId();
    }

    @Override
    public RoleResponse getOneById(Long id) {
        Assert.notNull(id, "id不能为空");
        Role role =  roleDao.selectById(id);
        if (Objects.isNull(role)) {
            throw new BizException("角色不存在");
        }
        RoleResponse response = new RoleResponse();
        BeanUtils.copyProperties(role, response);
        return response;
    }


}
