package com.friendsbook.user.management.service;

import com.friendsbook.user.management.DTO.UserRequest;
import com.friendsbook.user.management.DTO.UserResponse;
import com.friendsbook.user.management.Model.UserModel;
import com.friendsbook.user.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse addUser(UserRequest user) {
        UserModel userModel = new UserModel(user.getName(), user.getEmail(), user.getPassword(), "Active");
        UserModel savedUserModel = userRepository.save(userModel);
        UserResponse savedUser = new UserResponse(savedUserModel.getName(), savedUserModel.getEmail(), savedUserModel.getId(), savedUserModel.getStatus());
        return savedUser;

    }

    public UserResponse getUser(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isEmpty()) {
            throw new RuntimeException("User not found");
        } else {
            UserModel userModelEntity = userModel.get();
            UserResponse userResponse = new UserResponse(userModelEntity.getName(), userModelEntity.getEmail(), userModelEntity.getId(), userModelEntity.getStatus());
            return userResponse;
        }
    }

    public UserResponse updateUser(Integer id, UserRequest userRequest){
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isEmpty()) {
            throw new RuntimeException("User not found");
        } else {
            UserModel userModelEntity = userModel.get();
            userModelEntity.setName(userRequest.getName());
            userModelEntity.setEmail(userRequest.getEmail());
            userModelEntity.setPassword(userRequest.getPassword());
            UserModel updatedUserModel = userRepository.save(userModelEntity);
            UserResponse userResponse = new UserResponse(updatedUserModel.getName(), updatedUserModel.getEmail(), updatedUserModel.getId(), updatedUserModel.getStatus());
            return userResponse;
        }
    }

    public UserResponse deleteUser(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isEmpty()) {
            throw new RuntimeException("User not found");
        } else {
            UserModel userModelEntity = userModel.get();

            UserModel updatedUserModel = userRepository.save(userModelEntity.setStatus("Inactive"));
            UserResponse userResponse = new UserResponse(updatedUserModel.getName(), updatedUserModel.getEmail(), updatedUserModel.getId(), updatedUserModel.getStatus());
            return userResponse;
        }
    }
}
