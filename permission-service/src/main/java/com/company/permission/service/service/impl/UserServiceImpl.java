package com.company.permission.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.permission.common.constant.Constants;
import com.company.permission.common.exception.BizException;
import com.company.permission.common.model.User;
import com.company.permission.common.request.PageParamRequest;
import com.company.permission.common.request.UserRequest;
import com.company.permission.common.response.UserResponse;
import com.company.permission.service.dao.UserDao;
import com.company.permission.service.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author candylove
 * @date 2024/11/28 15:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Long save(UserRequest request) {
        Assert.notNull(request.getPhone(), "电话不能为空");
        // TODO: 2024/12/10 校验手机号的正确性
        if (Objects.isNull(request.getUsername())) {
            request.setUsername(request.getPhone());
        }
        // TODO: 2024/12/10 密码加密
        if (Objects.isNull(request.getPassword())) {
            request.setPassword(Constants.DEFAULT_PASSWORD);
        }
        User user = new User();
        BeanUtils.copyProperties(request, user);
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        User dbUser = getOne(lqw.eq(User::getUsername, request.getUsername()));
        if (Objects.isNull(user.getUserId())) {
            if (Objects.nonNull(dbUser)) {
                throw new BizException("账号不能重复");
            }
            save(user);
        } else {
            if (Objects.nonNull(dbUser) && !Objects.equals(dbUser.getUserId(), user.getUserId())) {
                throw new BizException("账号不能重复");
            }
            updateById(user);
        }
        return user.getUserId();
    }

    @Override
    public PageInfo<UserResponse> getList(PageParamRequest request) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<User> users = userDao.selectList(lqw);
        List<UserResponse> responses = new ArrayList<>();
        BeanUtils.copyProperties(users, responses);
        return new PageInfo<>(responses);
    }

    @Override
    public User getOneById(Long id) {
        User user = userDao.selectById(id);
        if (Objects.isNull(user)) {
            throw new BizException("用户不存在");
        }
        return user;
    }


}
