package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

    User getUserByUuid(String uuid);

    List<User> listUser();
}
