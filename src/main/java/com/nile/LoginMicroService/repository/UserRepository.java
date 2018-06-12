package com.nile.LoginMicroService.repository;

import com.nile.LoginMicroService.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {

    public UserEntity getByEmailAndPassword(String email,String password);
}
