package com.company.permission.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.permission.common.model.User;
import com.company.permission.common.request.PageParamRequest;
import com.company.permission.common.request.UserRequest;
import com.company.permission.common.response.UserResponse;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService extends IService<User> {

    /**
     * 新增(更新)用户
     * @param request
     * @return Long
     */
    Long save(UserRequest request);

    /**
     * 用户分页列表
     * @param request
     * @return Page
     */
    PageInfo<UserResponse> getList(PageParamRequest request);

    /**
     * 根据id获取用户
     * @param id
     * @return UserResponse
     */
    User getOneById(Long id);

}
