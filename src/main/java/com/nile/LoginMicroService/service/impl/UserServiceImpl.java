package com.nile.LoginMicroService.service.impl;

import com.nile.LoginMicroService.entity.UserEntity;
import com.nile.LoginMicroService.repository.UserRepository;
import com.nile.LoginMicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity editProfile(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity authenticate(String email, String password) {
        return userRepository.getByEmailAndPassword(email, password);
    }

    @Override
    public Boolean register(UserEntity userEntity) {
        return userRepository.save(userEntity)!=null;
    }

    @Override
    public List<UserEntity> saveAll(List<UserEntity> userEntities) {
        return (List<UserEntity>) userRepository.saveAll(userEntities);
    }


}
