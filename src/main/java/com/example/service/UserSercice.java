package com.example.service;

import com.example.entity.User;

import java.util.List;


public interface UserSercice {

    User getUserByUuid(String uuid);

    List<User> listUser(int currentPage, int pageSize);

}
