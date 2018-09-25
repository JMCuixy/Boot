package com.example.service.impl;

import com.example.bean.PageBean;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserSercice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerciceImpl implements UserSercice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUuid(String uuid) {
        return userMapper.getUserByUuid(uuid);
    }

    @Override
    public List<User> listUser(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userMapper.listUser();
        PageBean<User> userPageBean = new PageBean<>(currentPage, pageSize, users.size());
        userPageBean.setItems(users);
        return userPageBean.getItems();
    }
}
