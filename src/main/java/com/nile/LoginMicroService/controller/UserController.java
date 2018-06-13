package com.nile.LoginMicroService.controller;

import com.nile.LoginMicroService.dto.UserDTO;
import com.nile.LoginMicroService.entity.UserEntity;
import com.nile.LoginMicroService.service.UserService;
import com.nile.LoginMicroService.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, value = "/user/editProfile")
    public UserDTO editProfile(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        UserEntity userEntityTemp = userService.editProfile(userEntity);
        UserDTO userDTOTemp = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTOTemp);
        return userDTOTemp;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/authenticate")
    public UserDTO authenticate(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userService.authenticate(userDTO.getEmail(), userDTO.getPassword());
        if (userEntity == null)
            return null;
        UserDTO userDTOTemp = null;
        userDTOTemp = new UserDTO();
        BeanUtils.copyProperties(userEntity, userDTOTemp);
        return userDTOTemp;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/saveAll")
    public List<UserDTO> authenticate(@RequestBody List<UserEntity> userEntities) {
        List<UserEntity> userEntitiesTemp = userService.saveAll(userEntities);
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (UserEntity temp : userEntitiesTemp) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(temp, userDTO);

        }
        return userDTOList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/register")
    public Boolean register(@RequestBody UserEntity userEntities) {
        return userService.register(userEntities);
    }

}
