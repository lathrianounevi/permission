package com.company.permission.admin;

import com.company.permission.common.model.Role;
import com.company.permission.common.request.RoleRequest;
import com.company.permission.service.dao.RoleDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PermissionAdminApplicationTests {

    @Resource
    private RoleDao roleDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        PageHelper.startPage(1, 3);
        List<Role> role = roleDao.getList();
        PageInfo<Role> pageInfo = new PageInfo<>(role);

        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("当前页的记录"+pageInfo.getList());
    }




}
