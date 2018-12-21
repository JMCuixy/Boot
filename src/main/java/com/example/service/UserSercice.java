package com.example.service;

import com.example.bean.PageBean;
import com.example.entity.User;

import java.util.List;


public interface UserSercice {

    User getUserByUuid(String uuid);

    PageBean<User> listUser(int currentPage, int pageSize);

}
