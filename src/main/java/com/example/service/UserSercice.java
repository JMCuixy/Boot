package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserSercice {

    User getUserByUuid(String uuid);

    List<User> listUser();

}
