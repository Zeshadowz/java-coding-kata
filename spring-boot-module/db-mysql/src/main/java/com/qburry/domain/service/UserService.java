package com.qburry.domain.service;

import com.qburry.domain.model.UserEntity;
import com.qburry.domain.repository.UserRepository;
import com.qburry.domain.service.mapper.UserMapper;
import com.qburry.web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Long addUser(User user) {
        UserEntity entity = userMapper.toEntity(user);
        entity.setSalt("1lPDxsv4");
        return userRepository.save(entity).getId();
    }

    public List<User> getAllUsers() {
        return userMapper.toUsers(userRepository.findAll()).stream().toList();
    }
}
