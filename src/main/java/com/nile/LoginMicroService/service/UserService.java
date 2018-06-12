package com.nile.LoginMicroService.service;

import com.nile.LoginMicroService.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity authenticate(String email,String password);
    UserEntity editProfile(UserEntity userEntity);
    UserEntity register(UserEntity userEntity);
    List<UserEntity> saveAll(List<UserEntity> userEntities);
}
